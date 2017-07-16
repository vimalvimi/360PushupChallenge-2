package com.example.batman.a360pushupchallenge.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class PushupContract {

    public static final String CONTENT_AUTHORITY = "com.example.batman.a360pushupchallenge";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String NAME_PUSHUP_KNEE = "Knee Push-up";
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

    public static final class PushupWideGrip implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_WIDE_GRIP);

        public static final String TABLE_NAME = "wide_grip";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupClosedGrip implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_CLOSED_GRIP);

        public static final String TABLE_NAME = "closed_grip";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupStacked implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_STACKED);

        public static final String TABLE_NAME = "stacked";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupRaisedLeg implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_RAISED_LEG);

        public static final String TABLE_NAME = "raised_leg";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupReversed implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_REVERSED);

        public static final String TABLE_NAME = "reversed";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupDecline implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_DECLINE);

        public static final String TABLE_NAME = "decline";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupIncline implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_INCLINE);

        public static final String TABLE_NAME = "incline";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupKnuckle implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_KNUCKLE);

        public static final String TABLE_NAME = "knuckle";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupClapping implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_CLAPPING);

        public static final String TABLE_NAME = "clapping";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }

    public static final class PushupOneArmed implements BaseColumns {

        public static final Uri CONTENT_URI = Uri
                .withAppendedPath(BASE_CONTENT_URI, PATH_PUSHUP_ONE_ARMED);

        public static final String TABLE_NAME = "one_armed";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_SCORE = "score";
    }
}