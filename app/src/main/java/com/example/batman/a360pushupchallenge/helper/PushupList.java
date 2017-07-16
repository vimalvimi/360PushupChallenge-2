package com.example.batman.a360pushupchallenge.helper;

import android.net.Uri;
import android.util.Log;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.data.PushupContract;
import com.example.batman.a360pushupchallenge.model.Pushup;

import java.util.ArrayList;

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

    public String matchName(String exerciseName) {

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

    public String getNameFromUri(String uriLastPath) {

        switch (uriLastPath) {
            case PushupContract.PATH_PUSHUP_KNEE:
                return PushupContract.NAME_PUSHUP_KNEE;
            case PushupContract.PATH_PUSHUP_CLASSIC:
                return PushupContract.NAME_PUSHUP_CLASSIC;
            case PushupContract.PATH_PUSHUP_WIDE_GRIP:
                return PushupContract.NAME_PUSHUP_WIDE_GRIP;
            case PushupContract.PATH_PUSHUP_CLOSED_GRIP:
                return PushupContract.NAME_PUSHUP_CLOSED_GRIP;
            case PushupContract.PATH_PUSHUP_STACKED:
                return PushupContract.NAME_PUSHUP_STACKED;
            case PushupContract.PATH_PUSHUP_RAISED_LEG:
                return PushupContract.NAME_PUSHUP_RAISED_LEG;
            case PushupContract.PATH_PUSHUP_REVERSED:
                return PushupContract.NAME_PUSHUP_REVERSED;
            case PushupContract.PATH_PUSHUP_DECLINE:
                return PushupContract.NAME_PUSHUP_DECLINE;
            case PushupContract.PATH_PUSHUP_INCLINE:
                return PushupContract.NAME_PUSHUP_INCLINE;
            case PushupContract.PATH_PUSHUP_KNUCKLE:
                return PushupContract.NAME_PUSHUP_KNUCKLE;
            case PushupContract.PATH_PUSHUP_CLAPPING:
                return PushupContract.NAME_PUSHUP_CLAPPING;
            case PushupContract.PATH_PUSHUP_ONE_ARMED:
                return PushupContract.NAME_PUSHUP_ONE_ARMED;
            default:
                return PushupContract.NAME_PUSHUP_KNEE;
        }
    }

    public void preparePushup(ArrayList<Pushup> pushupArrayList) {
        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_KNEE,
                PushupContract.PATH_PUSHUP_KNEE, R.drawable.p1, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_CLASSIC,
                PushupContract.PATH_PUSHUP_CLASSIC, R.drawable.p2, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_WIDE_GRIP,
                PushupContract.PATH_PUSHUP_WIDE_GRIP, R.drawable.p3, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_CLOSED_GRIP,
                PushupContract.PATH_PUSHUP_CLOSED_GRIP, R.drawable.p4, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_STACKED,
                PushupContract.PATH_PUSHUP_STACKED, R.drawable.p5, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_RAISED_LEG,
                PushupContract.PATH_PUSHUP_RAISED_LEG, R.drawable.p6, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_REVERSED,
                PushupContract.PATH_PUSHUP_REVERSED, R.drawable.p7, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_DECLINE,
                PushupContract.PATH_PUSHUP_DECLINE, R.drawable.p8, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_INCLINE,
                PushupContract.PATH_PUSHUP_INCLINE, R.drawable.p9, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_KNUCKLE,
                PushupContract.PATH_PUSHUP_KNUCKLE, R.drawable.p10, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_CLAPPING,
                PushupContract.PATH_PUSHUP_CLAPPING, R.drawable.p11, 0));

        pushupArrayList.add(new Pushup(PushupContract.NAME_PUSHUP_ONE_ARMED,
                PushupContract.PATH_PUSHUP_ONE_ARMED, R.drawable.p12, 0));
    }
}
