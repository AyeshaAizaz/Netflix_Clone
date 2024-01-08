package com.example.netflixclone.dbhandler;

import android.net.Uri;

public class DataBaseSchema {

        public static final String DATABASE_NAME = "netflix.db";
        public static final int DATABASE_VERSION = 1;
        public static final String USER_TABLE = "user";
        public static final String MOVIE_TABLE = "movies";


        public static final String COLUMN_USER_ID = "user_id";
//        public static final String COLUMN_USER_NAME = "user_name";
        public static final String COLUMN_USER_EMAIL_ID = "user_email_id";
        public static final String COLUMN_USER_PASSWORD = "user_password";
        public static final String AUTHORITY = "com.example.login.provider";
        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
//        public static final String COLUMN_MOVIE_ID = "_id";
//        public static final String COLUMN_MOVIE_TITLE = "title";






}
