package com.example.batman.a360pushupchallenge.ui;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.data.PushupContract;
import com.example.batman.a360pushupchallenge.helper.PushupList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CounterActivity
        extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = "CounterActivity";

    public static final int PUSHUP_LOADER = 601;

    private String pushupLastPath;
    private String pushupName;

    private int livePushupCounter = 0;
    private int recordInt = 0;
    private Uri currentUri;

    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer10;

    PushupList pushupList;

    @BindView(R.id.counter_count_button)
    TextView counterButton;
    @BindView(R.id.counter_togo_text)
    TextView counterTogo;
    @BindView(R.id.counter_done_button)
    TextView doneButton;
    @BindView(R.id.counter_record)
    TextView record;
    @BindView(R.id.personal_record)
    TextView personalRecord;

    View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);

        parentLayout = findViewById(android.R.id.content);

        pushupList = new PushupList();

        if (getIntent().hasExtra(getString(R.string.extra_last_path))) {
            pushupLastPath = getIntent().getStringExtra(getString(R.string.extra_last_path));
            currentUri = Uri.parse(PushupContract.BASE_CONTENT_URI + "/" + pushupLastPath);
        }

        pushupName = (pushupList.getNameFromUri(pushupLastPath));
        setTitle(pushupName);

        String customFont = "Teko-Medium.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);

        //Get Generator
        pushupList = new PushupList();

        //Ting sound effect for touch
        mediaPlayer = MediaPlayer.create(this, R.raw.adapter_clink);
        mediaPlayer10 = MediaPlayer.create(this, R.raw.adapter_clink_10);

        counterButton.setTypeface(typeface);
        doneButton.setTypeface(typeface);
        record.setTypeface(typeface);
        personalRecord.setTypeface(typeface);
        counterTogo.setTypeface(typeface);

        counterButton.setText(String.valueOf(livePushupCounter));

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushupCounter();
            }
        });
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDoneButton();
            }
        });

        //Kickoff Loader
        getSupportLoaderManager().initLoader(PUSHUP_LOADER, null, this);
    }

    private void pushupCounter() {
        livePushupCounter++;
        counterButton.setText(String.valueOf(livePushupCounter));

        //If it hits multiple of 10 then sound 2
        if (livePushupCounter % 10 == 0) {
            if (mediaPlayer10 != null) {
                mediaPlayer10.start();
            }
        } else {
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        }

        //Push that record
        if (recordInt > 0) {
            if (0 <= (recordInt - livePushupCounter) && (recordInt - livePushupCounter) <= 5) {
                String motivationText = (recordInt + 1) - livePushupCounter + " more to break the record";
                counterTogo.setVisibility(View.VISIBLE);
                counterTogo.setText(motivationText);
            } else if (recordInt < livePushupCounter) {
                String motivationText = "Congrats, Your broke your own record !";
                counterTogo.setVisibility(View.VISIBLE);
                counterTogo.setText(motivationText);
            } else {
                counterTogo.setVisibility(View.GONE);
            }
        }
    }

    private void setDoneButton() {
        if (livePushupCounter > 0) {
            //Getting Score
            Integer currentScore = livePushupCounter;

            //Putting values in Column
            ContentValues values = new ContentValues();
            values.put(PushupContract.PushupKnee.COLUMN_SCORE, currentScore);

            // Show a toast message depending on whether or not the insertion was successful
            Uri newUri = getContentResolver().insert(currentUri, values);

            Log.d(TAG, "onCreate: NEW URI" + newUri);
            if (newUri == null) {
                // If the new content URI is null, then there was an error with insertion.
                Toast.makeText(getApplicationContext(),
                        getString(R.string.insert_failed), Toast.LENGTH_SHORT).show();

            } else {
                // Otherwise, the insertion was successful and we can display a toast.

                Toast.makeText(getApplicationContext(),
                        getString(R.string.insert_successful), Toast.LENGTH_SHORT).show();

                ProgressShare();
                finish();
            }

        } else {
            finish();
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String[] projection = {
                PushupContract.UNIVERSAL_SCORE};

        return new CursorLoader(this,
                currentUri,
                projection,
                null,
                null,
                "score DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        if (data == null || data.getCount() < 1) {
            return;
        }
        if (data.moveToFirst()) {
            String score = data.getString(0);
            record.setText(String.valueOf(score));
            recordInt = Integer.parseInt(score);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer = MediaPlayer.create(this, R.raw.adapter_clink);
        mediaPlayer10 = MediaPlayer.create(this, R.raw.adapter_clink_10);
    }

    @Override
    protected void onPause() {
        mediaPlayer.stop();
        mediaPlayer10.stop();
        mediaPlayer.release();
        mediaPlayer10.release();
        super.onPause();
    }

    private void ProgressShare() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,
                "Hi, I just did " + livePushupCounter + " " + pushupName +
                        " Push ups, \n #360PushupChallenge");

        try {
            startActivity(Intent.createChooser(shareIntent,
                    "Hi, I just did " + livePushupCounter + " " + pushupName +
                            " Push ups, \n #360PushupChallenge"));
        } catch (android.content.ActivityNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
