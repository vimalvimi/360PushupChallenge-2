package com.example.batman.a360pushupchallenge.helper;

import android.net.Uri;
import android.util.Log;

import com.example.batman.a360pushupchallenge.data.PushupContract;

public class PushupList {

    private static final String TAG = "PushupList";

    public String[] exerciseList = {
            PushupContract.NAME_PUSHUP_KNEE,
            PushupContract.NAME_PUSHUP_CLASSIC,
            PushupContract.NAME_PUSHUP_WIDE_GRIP,
            PushupContract.NAME_PUSHUP_CLOSED_GRIP,
            PushupContract.NAME_PUSHUP_STACKED,
            PushupContract.NAME_PUSHUP_RAISED_LEG,
            PushupContract.NAME_PUSHUP_REVERSED,
            PushupContract.NAME_PUSHUP_DECLINE,
            PushupContract.NAME_PUSHUP_INCLINE,
            PushupContract.NAME_PUSHUP_KNUCKLE,
            PushupContract.NAME_PUSHUP_CLAPPING,
            PushupContract.NAME_PUSHUP_ONE_ARMED,
    };

    public Uri ExerciseNameUriGenerator(String exerciseName) {

        Log.d(TAG, "ExerciseNameUriGenerator: " + exerciseName);

        return PushupContract.BASE_CONTENT_URI
                .buildUpon()
                .appendPath(matchName(exerciseName))
                .build();
    }

    private String matchName(String exerciseName) {

        switch (exerciseName) {
            case PushupContract.NAME_PUSHUP_KNEE:
                return PushupContract.PATH_PUSHUP_KNEE;
            case PushupContract.NAME_PUSHUP_CLASSIC:
                return PushupContract.PATH_PUSHUP_CLASSIC;
            case PushupContract.NAME_PUSHUP_WIDE_GRIP:
                return PushupContract.PATH_PUSHUP_WIDE_GRIP;
            case PushupContract.NAME_PUSHUP_CLOSED_GRIP:
                return PushupContract.PATH_PUSHUP_CLOSED_GRIP;
            case PushupContract.NAME_PUSHUP_STACKED:
                return PushupContract.PATH_PUSHUP_STACKED;
            case PushupContract.NAME_PUSHUP_RAISED_LEG:
                return PushupContract.PATH_PUSHUP_RAISED_LEG;
            case PushupContract.NAME_PUSHUP_REVERSED:
                return PushupContract.PATH_PUSHUP_REVERSED;
            case PushupContract.NAME_PUSHUP_DECLINE:
                return PushupContract.PATH_PUSHUP_DECLINE;
            case PushupContract.NAME_PUSHUP_INCLINE:
                return PushupContract.PATH_PUSHUP_INCLINE;
            case PushupContract.NAME_PUSHUP_KNUCKLE:
                return PushupContract.PATH_PUSHUP_KNUCKLE;
            case PushupContract.NAME_PUSHUP_CLAPPING:
                return PushupContract.PATH_PUSHUP_CLAPPING;
            case PushupContract.NAME_PUSHUP_ONE_ARMED:
                return PushupContract.PATH_PUSHUP_ONE_ARMED;
            default:
                return PushupContract.PATH_PUSHUP_KNEE;
        }
    }
}
