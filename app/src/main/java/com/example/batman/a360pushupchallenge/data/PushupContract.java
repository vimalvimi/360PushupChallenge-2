package com.example.batman.a360pushupchallenge.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class PushupContract {

    public static final String CONTENT_AUTHORITY = "com.example.batman.a360pushupchallenge";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_PUSHUP_KNEE = "knee";
    public static final String PATH_PUSHUP_CLASSIC = "classic";

    public static final String UNIVERSAL_ATTEMPT = "attempt";
    public static final String UNIVERSAL_SCORE = "score";

    // To prevent someone from accidentally instantiating the contract class, an empty constructor.
    public PushupContract() {
    }

    public static final class PushupKnee implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_KNEE);

        public static final String TABLE_NAME = "knee";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupClassic implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_CLASSIC);

        public static final String TABLE_NAME = "classic";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }
}


