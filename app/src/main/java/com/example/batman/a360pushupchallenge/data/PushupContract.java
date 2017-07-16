package com.example.batman.a360pushupchallenge.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class PushupContract {

    public static final String CONTENT_AUTHORITY = "com.example.batman.a360pushupchallenge";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String NAME_PUSHUP_KNEE = "Knee";
    public static final String NAME_PUSHUP_CLASSIC = "Classic";
    public static final String NAME_PUSHUP_WIDE_GRIP = "Wide Grip";
    public static final String NAME_PUSHUP_CLOSED_GRIP = "Close Grip";
    public static final String NAME_PUSHUP_STACKED = "Stacked";
    public static final String NAME_PUSHUP_RAISED_LEG = "Raised Leg";
    public static final String NAME_PUSHUP_REVERSED = "Reversed";
    public static final String NAME_PUSHUP_DECLINE = "Decline";
    public static final String NAME_PUSHUP_INCLINE = "Incline";
    public static final String NAME_PUSHUP_KNUCKLE = "Knuckle";
    public static final String NAME_PUSHUP_CLAPPING = "Clapping";
    public static final String NAME_PUSHUP_ONE_ARMED = "One Armed";
    public static final String PATH_PUSHUP_KNEE = "knee";

    public static final String PATH_PUSHUP_CLASSIC = "classic";
    public static final String PATH_PUSHUP_WIDE_GRIP = "wide_grip";
    public static final String PATH_PUSHUP_CLOSED_GRIP = "closed_grip";
    public static final String PATH_PUSHUP_STACKED = "stacked";
    public static final String PATH_PUSHUP_RAISED_LEG = "raised_leg";
    public static final String PATH_PUSHUP_REVERSED = "reversed";
    public static final String PATH_PUSHUP_DECLINE = "decline";
    public static final String PATH_PUSHUP_INCLINE = "incline";
    public static final String PATH_PUSHUP_KNUCKLE = "knuckle";
    public static final String PATH_PUSHUP_CLAPPING = "clapping";
    public static final String PATH_PUSHUP_ONE_ARMED = "one_armed";

    public static final String UNIVERSAL_ID = BaseColumns._ID;
    public static final String UNIVERSAL_SCORE = "score";

    // To prevent someone from accidentally instantiating the contract class, an empty constructor.
    public PushupContract() {
    }

    public static final class PushupKnee implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_KNEE);

        static final String TABLE_NAME = "knee";
        static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    static final class PushupClassic implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_CLASSIC);

        static final String TABLE_NAME = "classic";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupWideGrip implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_WIDE_GRIP);

        static final String TABLE_NAME = "wide_grip";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupClosedGrip implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_CLOSED_GRIP);

        static final String TABLE_NAME = "closed_grip";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupStacked implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_STACKED);

        static final String TABLE_NAME = "stacked";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupRaisedLeg implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_RAISED_LEG);

        static final String TABLE_NAME = "raised_leg";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupReversed implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_REVERSED);

        static final String TABLE_NAME = "reversed";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupDecline implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_DECLINE);

        static final String TABLE_NAME = "decline";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupIncline implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_INCLINE);

        static final String TABLE_NAME = "incline";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupKnuckle implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_KNUCKLE);

        static final String TABLE_NAME = "knuckle";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupClapping implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_CLAPPING);

        static final String TABLE_NAME = "clapping";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }

    static final class PushupOneArmed implements BaseColumns {

        static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_ONE_ARMED);

        static final String TABLE_NAME = "one_armed";
        static final String _ID = BaseColumns._ID;
        static final String COLUMN_SCORE = "score";
    }
}