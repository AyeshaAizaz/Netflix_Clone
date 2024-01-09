package com.example.netflixclone;

import static com.example.netflixclone.DatabaseSchema.DATABASE_NAME;
import static com.example.netflixclone.DatabaseSchema.DATABASE_VERSION;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LoginDatabaseHandler extends SQLiteOpenHelper {


    public LoginDatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createLoginTableQuery = "CREATE TABLE " + DatabaseSchema.USER_TABLE + " (" +
                DatabaseSchema.COLUMN_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseSchema.COLUMN_USEREMAIL + " TEXT NOT NULL, " +
                DatabaseSchema.COLUMN_USERPASS + " TEXT NOT NULL" + ")";
        db.execSQL(createLoginTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
