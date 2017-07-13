package com.example.batman.a360pushupchallenge.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PushupDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "records.db";
    private static final int DATABASE_VERSION = 2;

    public PushupDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_KNEE_TABLE =
                "CREATE TABLE " + PushupContract.PushupKnee.TABLE_NAME + " (" +
                        PushupContract.PushupKnee._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupKnee.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_CLASSIC_TABLE =
                "CREATE TABLE " + PushupContract.PushupClassic.TABLE_NAME + " (" +
                        PushupContract.PushupClassic._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupClassic.COLUMN_SCORE + " INTEGER NOT NULL);";

        sqLiteDatabase.execSQL(SQL_CREATE_KNEE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_CLASSIC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ PushupContract.PushupKnee.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ PushupContract.PushupClassic.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
