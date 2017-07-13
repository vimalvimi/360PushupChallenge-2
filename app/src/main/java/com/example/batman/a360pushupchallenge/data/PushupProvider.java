package com.example.batman.a360pushupchallenge.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;

public class PushupProvider extends ContentProvider {

    public PushupDbHelper mPushupDbHelper;

    public static final int CODE_KNEE = 100;
    public static final int CODE_CLASSIC = 200;
    public static final int CODE_WIDE_GRIP = 300;
    public static final int CODE_CLOSED_GRIP = 400;
    public static final int CODE_STACKED = 500;
    public static final int CODE_RAISED_LEG = 600;
    public static final int CODE_REVERSED_LEG = 700;
    public static final int CODE_DECLINE = 800;
    public static final int CODE_INCLINE = 900;
    public static final int CODE_KNUCKLE = 1000;
    public static final int CODE_CLAPPING = 1100;
    public static final int CODE_ONE_ARMED = 1200;

    public static final UriMatcher URI_MATCHER = uriMatch();

    private static UriMatcher uriMatch() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String contentAuthority = PushupContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_KNEE, CODE_KNEE);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_CLASSIC, CODE_CLASSIC);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_WIDE_GRIP, CODE_WIDE_GRIP);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_CLOSED_GRIP, CODE_CLOSED_GRIP);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_STACKED, CODE_STACKED);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_RAISED_LEG, CODE_RAISED_LEG);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_REVERSED, CODE_REVERSED_LEG);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_DECLINE, CODE_DECLINE);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_INCLINE, CODE_INCLINE);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_KNUCKLE, CODE_KNUCKLE);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_CLAPPING, CODE_CLAPPING);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_ONE_ARMED, CODE_ONE_ARMED);
        return uriMatcher;
    }

    @Override
    public boolean onCreate() {
        mPushupDbHelper = new PushupDbHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        Cursor mCursor;

        switch (URI_MATCHER.match(uri)) {
            case CODE_KNEE:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupKnee.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_CLASSIC:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupClassic.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_WIDE_GRIP:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupWideGrip.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_CLOSED_GRIP:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupClosedGrip.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_STACKED:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupStacked.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_RAISED_LEG:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupRaisedLeg.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_REVERSED_LEG:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupReversed.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_DECLINE:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupDecline.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_INCLINE:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupIncline.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_KNUCKLE:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupKnuckle.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_CLAPPING:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupClapping.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case CODE_ONE_ARMED:
                mCursor = mPushupDbHelper.getReadableDatabase().query(
                        PushupContract.PushupOneArmed.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);

        }
        mCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return mCursor;
    }


    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    @Override
    public Uri insert(@NonNull Uri uri, ContentValues contentValues) {

        final int match = URI_MATCHER.match(uri);

        SQLiteDatabase sqlDb;
        long id = 0;

        switch (match) {
            case CODE_KNEE: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupKnee.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupKnee.CONTENT_URI + "/" + id + "/");
            }
            case CODE_CLASSIC: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupClassic.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupClassic.CONTENT_URI + "/" + id + "/");
            }
            case CODE_WIDE_GRIP: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupWideGrip.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupWideGrip.CONTENT_URI + "/" + id + "/");
            }
            case CODE_CLOSED_GRIP: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupClosedGrip.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupClosedGrip.CONTENT_URI + "/" + id + "/");
            }
            case CODE_STACKED: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupStacked.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupStacked.CONTENT_URI + "/" + id + "/");
            }
            case CODE_RAISED_LEG: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupRaisedLeg.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupRaisedLeg.CONTENT_URI + "/" + id + "/");
            }
            case CODE_REVERSED_LEG: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupReversed.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupReversed.CONTENT_URI + "/" + id + "/");
            }
            case CODE_DECLINE: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupDecline.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupDecline.CONTENT_URI + "/" + id + "/");
            }
            case CODE_INCLINE: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupIncline.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupIncline.CONTENT_URI + "/" + id + "/");
            }
            case CODE_KNUCKLE: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupKnuckle.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupKnuckle.CONTENT_URI + "/" + id + "/");
            }
            case CODE_CLAPPING: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupClapping.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupClapping.CONTENT_URI + "/" + id + "/");
            }
            case CODE_ONE_ARMED: {
                sqlDb = mPushupDbHelper.getWritableDatabase();
                id = sqlDb.insert(PushupContract.PushupOneArmed.TABLE_NAME, null, contentValues);
                getContext().getContentResolver().notifyChange(uri, null);
                return Uri.parse(PushupContract.PushupOneArmed.CONTENT_URI + "/" + id + "/");
            }
            default:
                throw new IllegalStateException("Insertion is not supported for " + uri);
        }

    }

    @Override
    public int delete(@NonNull Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;

    }
}
