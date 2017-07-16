package com.example.batman.a360pushupchallenge.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PushupDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "records.db";
    private static final int DATABASE_VERSION = 3;

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

        final String SQL_CREATE_WIDE_GRIP_TABLE =
                "CREATE TABLE " + PushupContract.PushupWideGrip.TABLE_NAME + " (" +
                        PushupContract.PushupWideGrip._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupWideGrip.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_CLOSED_GRIP_TABLE =
                "CREATE TABLE " + PushupContract.PushupClosedGrip.TABLE_NAME + " (" +
                        PushupContract.PushupClosedGrip._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupClosedGrip.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_STACKED_GRIP_TABLE =
                "CREATE TABLE " + PushupContract.PushupStacked.TABLE_NAME + " (" +
                        PushupContract.PushupStacked._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupStacked.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_RAISED_LEG_TABLE =
                "CREATE TABLE " + PushupContract.PushupRaisedLeg.TABLE_NAME + " (" +
                        PushupContract.PushupRaisedLeg._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupRaisedLeg.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_REVERSED_TABLE =
                "CREATE TABLE " + PushupContract.PushupReversed.TABLE_NAME + " (" +
                        PushupContract.PushupReversed._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupReversed.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_DECLINE_TABLE =
                "CREATE TABLE " + PushupContract.PushupDecline.TABLE_NAME + " (" +
                        PushupContract.PushupDecline._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupDecline.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_INCLINE_TABLE =
                "CREATE TABLE " + PushupContract.PushupIncline.TABLE_NAME + " (" +
                        PushupContract.PushupIncline._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupIncline.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_KNUCKLE_TABLE =
                "CREATE TABLE " + PushupContract.PushupKnuckle.TABLE_NAME + " (" +
                        PushupContract.PushupKnuckle._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupKnuckle.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_CLAPPING_TABLE =
                "CREATE TABLE " + PushupContract.PushupClapping.TABLE_NAME + " (" +
                        PushupContract.PushupClapping._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupClapping.COLUMN_SCORE + " INTEGER NOT NULL);";

        final String SQL_CREATE_ONE_ARMED_TABLE =
                "CREATE TABLE " + PushupContract.PushupOneArmed.TABLE_NAME + " (" +
                        PushupContract.PushupOneArmed._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        PushupContract.PushupOneArmed.COLUMN_SCORE + " INTEGER NOT NULL);";

        sqLiteDatabase.execSQL(SQL_CREATE_KNEE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_CLASSIC_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_WIDE_GRIP_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_CLOSED_GRIP_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_STACKED_GRIP_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_RAISED_LEG_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_REVERSED_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_DECLINE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_INCLINE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_KNUCKLE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_CLAPPING_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ONE_ARMED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupKnee.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupClassic.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupWideGrip.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupClosedGrip.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupStacked.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupRaisedLeg.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupReversed.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupDecline.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupIncline.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupKnuckle.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupClapping.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PushupContract.PushupOneArmed.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
