package com.example.netflixclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button login, signUp, forgot;
    ImageButton im;
    EditText email, pass;
    ValidationChecks validationChecks;
    NetworkReceiver networkReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        validationChecks = new ValidationChecks();
        networkReceiver = new NetworkReceiver();
        login = (Button) findViewById(R.id.signIn);
        signUp = (Button) findViewById(R.id.signUp);
        im = (ImageButton) findViewById(R.id.im);
        forgot = (Button) findViewById(R.id.forgot);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
        im.setOnClickListener(this);
        forgot.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String email_check = email.getText().toString();
        String pass_check = pass.getText().toString();

        if(v.getId() == R.id.signIn) {
            if (networkReceiver.isNetworkAvailable(LoginActivity.this)) {
                if (!email_check.equals("") && !pass_check.equals("")) {
                    if (validationChecks.isEmailOrPhoneValid(email_check) ||
                            validationChecks.isPasswordValid(pass_check)) {
                        Intent login_intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(login_intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Incorrect Email/Phone or Password Syntax",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "Email/Password cannot be empty",
                            Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(LoginActivity.this, "Please Connect to Network",
                        Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId() == R.id.signUp){
            Intent signUp_intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(signUp_intent);
        }
        else if(v.getId() == R.id.im){
            Intent back_intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(back_intent);
        }
        else if(v.getId() == R.id.forgot){
            //make activity
        }

    }
}