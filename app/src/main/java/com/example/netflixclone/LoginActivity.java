package com.example.netflixclone;

import android.content.ContentValues;
import com.example.netflixclone.dbhandler.DataBaseSchema;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity  {

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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_check = email.getText().toString();
                String pass_check = pass.getText().toString();
                ContentValues values = new ContentValues();
                values.put(DataBaseSchema.COLUMN_USER_EMAIL_ID, "user123");
                values.put(DataBaseSchema.COLUMN_USER_PASSWORD , "password123");
                Uri resultUri = getContentResolver().insert(DataBaseSchema.CONTENT_URI, values);

                if (resultUri != null) {
                    // The data was successfully inserted, you can use resultUri to identify the new item
                    String insertedItemId = resultUri.getLastPathSegment();

                    // You can use the insertedItemId as needed, for example, display a success message or navigate to another screen
                    Toast.makeText(getApplicationContext(), "Item inserted with ID: " + insertedItemId, Toast.LENGTH_SHORT).show();
                } else {
                    // Failed to insert data, handle the error
                    Toast.makeText(getApplicationContext(), "Failed to insert data", Toast.LENGTH_SHORT).show();
                }


                // Example: Querying user data during login
                String[] projection = {DataBaseSchema.COLUMN_USER_EMAIL_ID, DataBaseSchema.COLUMN_USER_PASSWORD};
                String selection = DataBaseSchema.COLUMN_USER_EMAIL_ID + "=? AND " + DataBaseSchema.COLUMN_USER_PASSWORD + "=?";
                String[] selectionArgs = {email_check, pass_check};

                Cursor cursor = getContentResolver().query(DataBaseSchema.CONTENT_URI, projection, selection, selectionArgs, null);
                Toast.makeText(getApplicationContext(),"email Before cursor check: " + email_check,Toast.LENGTH_LONG).show();
                if (cursor != null && cursor.moveToFirst()) {
                    // User found, perform login actions
                    // ...
                    Toast.makeText(getApplicationContext(),"email : " + email_check,Toast.LENGTH_LONG).show();


                } else {
                    // User not found, handle accordingly
                    // ...

                    Toast.makeText(getApplicationContext(),"check : else",Toast.LENGTH_LONG).show();
                }

                if (cursor != null) {
                    Toast.makeText(getApplicationContext(),"check : if cursor close",Toast.LENGTH_LONG).show();
                    cursor.close();
                }
            }
        });
//        signUp.setOnClickListener(this);
//        im.setOnClickListener(this);
//        forgot.setOnClickListener(this);


    }

//    @Override
//    public void onClick(View v) {
//        String email_check = email.getText().toString();
//        String pass_check = pass.getText().toString();
//        ContentValues values = new ContentValues();
//        values.put(DataBaseSchema.COLUMN_USER_EMAIL_ID, "user123");
//        values.put(DataBaseSchema.COLUMN_USER_PASSWORD , "password123");
//        Uri resultUri = getContentResolver().insert(DataBaseSchema.CONTENT_URI, values);
//
//        // Example: Querying user data during login
//        String[] projection = {DataBaseSchema.COLUMN_USER_EMAIL_ID, DataBaseSchema.COLUMN_USER_PASSWORD};
//        String selection = DataBaseSchema.COLUMN_USER_EMAIL_ID + "=? AND " + DataBaseSchema.COLUMN_USER_PASSWORD + "=?";
//        String[] selectionArgs = {email_check, pass_check};
//
//        Cursor cursor = getContentResolver().query(DataBaseSchema.CONTENT_URI, projection, selection, selectionArgs, null);
//
//        if (cursor != null && cursor.moveToFirst()) {
//            // User found, perform login actions
//            // ...
//            Toast.makeText(getApplicationContext(),"email : "+email_check,Toast.LENGTH_LONG).show();;
//
//
//
//        } else {
//            // User not found, handle accordingly
//            // ...
//        }
//
//        if (cursor != null) {
//            cursor.close();
//        }
//    }
//        if(v.getId() == R.id.signIn) {
//            if (networkReceiver.isNetworkAvailable(LoginActivity.this)) {
//                if (!email_check.equals("") && !pass_check.equals("")) {
//                    if (validationChecks.isEmailOrPhoneValid(email_check) ||
//                            validationChecks.isPasswordValid(pass_check)) {
//                        Intent login_intent = new Intent(LoginActivity.this, HomeActivity.class);
//                        startActivity(login_intent);
//                    } else {
//                        Toast.makeText(LoginActivity.this, "Incorrect Email/Phone or Password Syntax",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(LoginActivity.this, "Email/Password cannot be empty",
//                            Toast.LENGTH_SHORT).show();
//                }
//            }
//            else{
//                Toast.makeText(LoginActivity.this, "Please Connect to Network",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//        else if(v.getId() == R.id.signUp){
//            Intent signUp_intent = new Intent(LoginActivity.this, SignUpActivity.class);
//            startActivity(signUp_intent);
//        }
//        else if(v.getId() == R.id.im){
//            Intent back_intent = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(back_intent);
//        }
//        else if(v.getId() == R.id.forgot){
//            //make activity
//        }

    }
