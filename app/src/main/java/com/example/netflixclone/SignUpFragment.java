package com.example.netflixclone;

import android.content.Intent;
import android.os.Bundle;
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


                String password = passEditText.getText().toString();
                if(!password.equals("")){
                    if(ValidationChecks.isPasswordValid(password)){
                        Intent signin_intent = new Intent(getActivity(), LoginActivity.class);
                        getActivity().startActivity(signin_intent);
                        Toast.makeText(getActivity(), "Account Creation Successful",
                                Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Log.d("PasswordValidation", "Incorrect Password Syntax: " + password);
                        Toast.makeText(getActivity(), "Incorrect Password Syntax",
                                Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getActivity(), "Password cannot be empty",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
