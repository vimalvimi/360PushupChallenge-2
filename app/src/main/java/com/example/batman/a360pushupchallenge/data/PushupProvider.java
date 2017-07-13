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

    public static final UriMatcher URI_MATCHER = uriMatch();

    private static UriMatcher uriMatch() {
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String contentAuthority = PushupContract.CONTENT_AUTHORITY;

        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_KNEE, CODE_KNEE);
        uriMatcher.addURI(contentAuthority, PushupContract.PATH_PUSHUP_CLASSIC, CODE_CLASSIC);

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
