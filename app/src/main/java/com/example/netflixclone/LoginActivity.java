package com.example.netflixclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button login, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.signIn);
        signUp = (Button) findViewById(R.id.signUp);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.signIn){
            Intent login_intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(login_intent);
        }
        else if(v.getId() == R.id.signUp){
            Intent signUp_intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(signUp_intent);
        }

    }
}