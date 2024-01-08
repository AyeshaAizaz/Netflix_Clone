package com.example.netflixclone.dbhandler;


import static com.example.netflixclone.dbhandler.DataBaseSchema.DATABASE_NAME;
import static com.example.netflixclone.dbhandler.DataBaseSchema.DATABASE_VERSION;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LoginDatabaseHandler extends SQLiteOpenHelper {

    public LoginDatabaseHandler(Context context) {
//        factory is null so sqlite uses default configuration
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }

//    public DataBaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createLoginTableQuery = "CREATE TABLE " + DataBaseSchema.USER_TABLE + " ("
                + DataBaseSchema.COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataBaseSchema.COLUMN_USER_EMAIL_ID + " TEXT NOT NULL ,"
                + DataBaseSchema.COLUMN_USER_PASSWORD+ " TEXT NOT NULL"
                + ")";
        db.execSQL(createLoginTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implement database upgrade logic if needed
    }



}
