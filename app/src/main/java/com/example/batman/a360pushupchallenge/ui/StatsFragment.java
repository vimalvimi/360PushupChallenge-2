package com.example.batman.a360pushupchallenge.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.data.PushupContract;
import com.example.batman.a360pushupchallenge.helper.PushupList;
import com.example.batman.a360pushupchallenge.model.PushUpStats;
import com.example.batman.a360pushupchallenge.model.PushupQuote;
import com.example.batman.a360pushupchallenge.remote.QuoteAPI;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int STATS_LOADER_ID = 501;

    private static final String TAG = "StatsFragment";

    List<PushUpStats> currentScore;

    String selectedExercise = PushupContract.NAME_PUSHUP_WIDE_GRIP;

    Uri currentUri;
    PushupList pushupList;

    Random random;
    int randomQuoteNumber;

    @BindView(R.id.pushup_spinner)
    Spinner spinner;
    @BindView(R.id.pushup_chart)
    BarChart barChart;

    @Override
    public void onResume() {
        super.onResume();
        resetLoader();
    }

    @BindView(R.id.stats_personal_attempt_title)
    TextView attemptTitle;
    @BindView(R.id.stats_personal_record_title)
    TextView recordTitle;
    @BindView(R.id.stats_personal_record_value)
    TextView recordValue;
    @BindView(R.id.stats_personal_attempt_value)
    TextView attemptValue;
    @BindView(R.id.random_quote)
    TextView randomQuote;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stats, container, false);
        ButterKnife.bind(this, rootView);

        //Font Setting
        String customFont = "Teko-Medium.ttf";
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), customFont);

        recordValue.setTypeface(typeface);
        recordTitle.setTypeface(typeface);
        attemptValue.setTypeface(typeface);
        attemptTitle.setTypeface(typeface);

        //Load
        pushupList = new PushupList();

        //Spinner Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(rootView.getContext(),
                android.R.layout.simple_spinner_dropdown_item, pushupList.exerciseList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Spinner Click Listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resetLoader();
                selectedExercise = spinner.getSelectedItem().toString();
                resetLoader();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Null
            }
        });
        getLoaderManager().initLoader(STATS_LOADER_ID, null, this);

        //Quote
        if (isNetworkAvailable()) {
            getQuoteFrom();
        } else {
            randomQuote.setVisibility(View.GONE);
        }

        return rootView;
    }

    public void getQuoteFrom() {

        random = new Random();
        randomQuoteNumber = random.nextInt();

        Log.d(TAG, "getQuoteFrom: RUNNING QUOTE");
        QuoteAPI.Factory.getInstance().getPushup().enqueue(new Callback<List<PushupQuote>>() {
            @Override
            public void onResponse(Call<List<PushupQuote>> call, Response<List<PushupQuote>> response) {

                int randomQuoteNumberSize = response.body().size();
                String quote = response.body().get(random.nextInt(randomQuoteNumberSize)).getQuoteText();
                randomQuote.setText(String.valueOf(quote));
            }

            @Override
            public void onFailure(Call<List<PushupQuote>> call, Throwable t) {
                Log.e("Failed", t.getMessage());
            }
        });

    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityMgr = (ConnectivityManager) getContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public void resetLoader() {
        getLoaderManager().restartLoader(STATS_LOADER_ID, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {


        currentUri = pushupList.ExerciseNameUriGenerator(selectedExercise);

        String[] projection = {
                PushupContract.UNIVERSAL_ID,
                PushupContract.UNIVERSAL_SCORE};

        return new CursorLoader(getContext(),
                currentUri,
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        BarDataSet barDataSet;
        BarData barData;

        currentScore = new ArrayList<>();

        if (data != null && data.getCount() != 0) {
            while (data.moveToNext()) {
                String attempt = data.getString(0);
                String score = data.getString(1);

                int attemptInt = Integer.parseInt(attempt);
                int scoreInt = Integer.parseInt(score);

                currentScore.add(new PushUpStats(attemptInt, scoreInt));
            }
        }

        //Fill the Stats
        attemptValue.setText(String.valueOf(currentScore.size()));

        int recordValueResult = 0;
        for (int i = 0; i < currentScore.size(); i++) {
            if (currentScore.get(i).getCurrentScore() > recordValueResult) {
                recordValueResult = currentScore.get(i).getCurrentScore();
            }
        }
        recordValue.setText(String.valueOf(recordValueResult));

        //Fill the Chart
        if (currentScore.size() <= 20) {
            for (int i = 0; i < currentScore.size(); i++) {
                barEntries.add(new BarEntry(i, currentScore.get(i).getCurrentScore()));
            }
        } else {
            List<PushUpStats> subList = currentScore.
                    subList(Math.max(0, currentScore.size() - 20), currentScore.size());
            for (int i = 0; i < subList.size(); i++) {
                barEntries.add(new BarEntry(i, subList.get(i).getCurrentScore()));
            }
        }

        barDataSet = new BarDataSet(barEntries, getString(R.string.project));
        barData = new BarData(barDataSet);

        barDataSet.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        barDataSet.setFormLineWidth(1f);
        barDataSet.setDrawValues(false);

        barChart.setData(barData);

        YAxis yAxisLeft = barChart.getAxisLeft();
        yAxisLeft.setDrawZeroLine(true);
        yAxisLeft.setTextColor(Color.LTGRAY);
        yAxisLeft.setDrawTopYLabelEntry(true);
        yAxisLeft.setGranularityEnabled(true);
        yAxisLeft.setGranularity(1f);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.LTGRAY);
        xAxis.setDrawLabels(false);

        barChart.animateY(500);
        barChart.setTouchEnabled(false);
        barChart.setDragEnabled(false);
        barChart.setScaleEnabled(false);
        barChart.getAxisRight().setEnabled(false);
        barChart.setHighlightFullBarEnabled(false);
        barChart.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
        barChart.setHorizontalScrollBarEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.setVisibleXRangeMinimum(14f);
        barChart.getDescription().setEnabled(false);
        barChart.setVisibleXRangeMaximum(30f);

        Legend legend = barChart.getLegend();
        legend.setEnabled(false);

        barChart.invalidate();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        currentScore.clear();
    }
}
