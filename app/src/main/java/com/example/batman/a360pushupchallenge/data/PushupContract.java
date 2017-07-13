package com.example.batman.a360pushupchallenge.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class PushupContract {

    public static final String CONTENT_AUTHORITY = "com.example.batman.a360pushupchallenge";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_PUSHUP_KNEE = "knee";
    public static final String PATH_PUSHUP_CLASSIC = "classic";

    public static final class PushupKnee implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_PUSHUP_KNEE)
                .build();

        public static final String TABLE_NAME = "knee";
        public static final String COLUMN_ATTEMPT = "attempt";
        public static final String COLUMN_SCORE = "score";

    }

    public static final class PushupClassic implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_PUSHUP_CLASSIC)
                .build();

        public static final String TABLE_NAME = "classic";
        public static final String COLUMN_ATTEMPT = "attempt";
        public static final String COLUMN_SCORE = "score";

    }
}


