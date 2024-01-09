package com.example.netflixclone;

import android.net.Uri;

public class DatabaseSchema {

    public static final String DATABASE_NAME = "user_details.db";
    public static final int DATABASE_VERSION = 1;
    public static final String USER_TABLE = "user";
    public static final String COLUMN_USERID = "user_id";
    public static final String COLUMN_USEREMAIL = "user_email";
    public static final String COLUMN_USERPASS = "user_password";
    public static final String AUTHORITY = "com.example.netflixclone.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

}
