package com.example.netflixclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {

    private EditText emailEditText;
    private static String email;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance(String email_sign) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString("email", email_sign);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // Use the correct ID for emailEditText
        emailEditText = view.findViewById(R.id.email2);

        // Retrieve the email value from arguments
        if (getArguments() != null) {
            String email = getArguments().getString("email");
            // Set the email value to the emailEditText
            emailEditText.setText(email);
        }

        return view;
    }
}
