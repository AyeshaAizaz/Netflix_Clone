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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        validationChecks = new ValidationChecks();
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

        if(v.getId() == R.id.signIn){
            if(validationChecks.isEmailOrPhoneValid(email.getText().toString()) ||
                    validationChecks.isPasswordValid(pass.getText().toString())){
                Intent login_intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(login_intent);
            }
            else{
                Toast.makeText(LoginActivity.this, "Incorrect Email/Phone or Password Syntax",
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