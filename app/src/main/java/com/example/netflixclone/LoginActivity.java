package com.example.netflixclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button login, signUp, forgot;
    ImageButton im;
    private static final String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String phonePattern = "^\\+\\d{10,}$\n";
    private static final Pattern emailpattern = Pattern.compile(emailPattern);
    private static final Pattern phonepattern = Pattern.compile(phonePattern);
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
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
            if(validation_checks()){
                Intent login_intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(login_intent);
            }
            else{
                Toast.makeText(LoginActivity.this, "Incorrect Email/Phone", Toast.LENGTH_SHORT).show();
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

    private boolean validation_checks(){
        boolean valid = false;
        if(email.getText().toString() != null && pass.getText().toString() != null){
            Matcher emailmatcher = emailpattern.matcher(email.getText().toString());
            Matcher phonematcher = phonepattern.matcher(email.getText().toString());
            if(emailmatcher.matches() || phonematcher.matches()){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}