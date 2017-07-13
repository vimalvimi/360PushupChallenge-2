package com.example.batman.a360pushupchallenge.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.adapter.PushupAdapter;
import com.example.batman.a360pushupchallenge.model.Pushup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity
        extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int PUSHUP_LOADER = 0;

    private List<Pushup> pushupList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PushupAdapter pushupAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.pushup_list_recycler_view);
        pushupAdapter = new PushupAdapter(pushupList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(pushupAdapter);

        //Kickoff Loader
        getSupportLoaderManager().initLoader(PUSHUP_LOADER, null, this);

        preparePushup();
    }

    private void preparePushup() {
        pushupList.add(new Pushup("Knee Push-up", "knee", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Classic", "classic", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Wide Grip", "wide_grip", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Close Grip", "closed_grip", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Stacked", "stacked", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Raised Leg", "raised_leg", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Reversed", "reversed", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Decline", "decline", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Incline", "incline", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Knuckle", "knuckle", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Clapping", "clapping", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("One Armed", "one_armed", R.drawable.knee_1, 0));
        pushupAdapter.notifyDataSetChanged();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
