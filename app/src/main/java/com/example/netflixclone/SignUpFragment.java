package com.example.netflixclone;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    private Button create;
    private EditText emailEditText, passEditText;
    private static String email;
    ValidationChecks validationChecks;
    NetworkReceiver networkReceiver;
    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance(String email_sign) {
        SignUpFragment fragment = new SignUpFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        validationChecks = new ValidationChecks();
        networkReceiver = new NetworkReceiver();
        // Use the correct ID for emailEditText
        emailEditText = view.findViewById(R.id.email2);
        passEditText = view.findViewById(R.id.password1);
        create = view.findViewById(R.id.create);

        if (getArguments() != null) {
            email = getArguments().getString("user_email", "");
            // Set the email value to the emailEditText
            emailEditText.setText(email);
        }
        
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //final ContentValues values = new ContentValues();
                String email_db = emailEditText.getText().toString();
                String password = passEditText.getText().toString();
                String[] projection = {DatabaseSchema.COLUMN_USEREMAIL};
                String selection = DatabaseSchema.COLUMN_USEREMAIL + "=?";
                String[] selectionArgs = {email_db};

                Cursor cursor = getActivity().getContentResolver().query(DatabaseSchema.CONTENT_URI, projection, selection, selectionArgs, null);

                if(networkReceiver.isNetworkAvailable(getActivity())) {
                    if (!password.equals("")) {
                        if (ValidationChecks.isPasswordValid(password)) {
                            if (cursor != null && cursor.moveToFirst()) {
                                // User already exists
                                Toast.makeText(getActivity(), "User already registered", Toast.LENGTH_SHORT).show();
                                cursor.close();
                            } else {
                                // User does not exist, proceed with registration
                                ContentValues values = new ContentValues();
                                values.put(DatabaseSchema.COLUMN_USEREMAIL, email_db);
                                values.put(DatabaseSchema.COLUMN_USERPASS, password);
                                Toast.makeText(getActivity(), "Item Inserted", Toast.LENGTH_SHORT).show();

                                Uri resUri = getActivity().getContentResolver().insert(DatabaseSchema.CONTENT_URI, values);

                                if (resUri != null) {
                                    Toast.makeText(getActivity(), "User registered successfully", Toast.LENGTH_SHORT).show();
                                    Intent signin_intent = new Intent(getActivity(), LoginActivity.class);
                                    getActivity().startActivity(signin_intent);
                                } else {
                                    Toast.makeText(getActivity(), "Failed to register user", Toast.LENGTH_SHORT).show();
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                        else {
                            Log.d("PasswordValidation", "Incorrect Password Syntax: " + password);
                            Toast.makeText(getActivity(), "Incorrect Password Syntax",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getActivity(), "Password cannot be empty",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getActivity(), "Please Connect to Network",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
