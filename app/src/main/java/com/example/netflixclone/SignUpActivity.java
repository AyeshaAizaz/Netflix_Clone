package com.example.netflixclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SignUpActivity extends AppCompatActivity {

    Button start;
    ImageButton im1;
    EditText email1;
    ValidationChecks validationChecks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email1 = (EditText) findViewById(R.id.email1);
        validationChecks = new ValidationChecks();
        start = (Button) findViewById(R.id.start);
        im1 = (ImageButton) findViewById(R.id.im1);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validationChecks.isEmailOrPhoneValid(email1.getText().toString())) {
                    String email_sign = email1.getText().toString();
                    SignUpFragment signUpFragment = SignUpFragment.newInstance(email_sign);
                    replaceFragment(new SignUpFragment());
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Incorrect Email/Phone Syntax",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cross_intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(cross_intent);
            }
        });
    }

    private void replaceFragment(SignUpFragment signUpFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout, signUpFragment);
        fragmentTransaction.commit();
    }
}