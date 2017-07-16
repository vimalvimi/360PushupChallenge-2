package com.example.batman.a360pushupchallenge.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.adapter.PushupAdapter;
import com.example.batman.a360pushupchallenge.model.Pushup;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final int LIST_STATS_LOADER = 601;

    private List<Pushup> pushupList = new ArrayList<>();
    private PushupAdapter pushupAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.pushup_list_recycler_view);
        pushupAdapter = new PushupAdapter(pushupList, getActivity());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration divider =
                new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.custom_divider));
        recyclerView.addItemDecoration(divider);

        recyclerView.setAdapter(pushupAdapter);

        preparePushup();
        return rootView;
    }

    private void preparePushup() {
        pushupList.add(new Pushup(getString(R.string.name_knee_pushup),
                getString(R.string.last_path_knee_pushup), R.drawable.p1, 0));

        pushupList.add(new Pushup(getString(R.string.name_classic),
                getString(R.string.last_path_classic), R.drawable.p2, 0));

        pushupList.add(new Pushup(getString(R.string.name_wide_grip),
                getString(R.string.last_path_wide_grip), R.drawable.p3, 0));

        pushupList.add(new Pushup(getString(R.string.name_close_grip),
                getString(R.string.last_path_closed_grip), R.drawable.p4, 0));

        pushupList.add(new Pushup(getString(R.string.name_stacked),
                getString(R.string.last_path_stacked), R.drawable.p5, 0));

        pushupList.add(new Pushup(getString(R.string.name_raised_leg),
                getString(R.string.last_path_raised_leg), R.drawable.p6, 0));

        pushupList.add(new Pushup(getString(R.string.name_reversed),
                getString(R.string.last_path_reversed), R.drawable.p7, 0));

        pushupList.add(new Pushup(getString(R.string.name_decline),
                getString(R.string.last_path_decline), R.drawable.p8, 0));

        pushupList.add(new Pushup(getString(R.string.name_incline),
                getString(R.string.last_path_incline), R.drawable.p9, 0));

        pushupList.add(new Pushup(getString(R.string.name_knuckle),
                getString(R.string.last_path_knuckle), R.drawable.p10, 0));

        pushupList.add(new Pushup(getString(R.string.name_clapping),
                getString(R.string.last_path_clapping), R.drawable.p11, 0));

        pushupList.add(new Pushup(getString(R.string.name_one_armed),
                getString(R.string.last_path_one_armed), R.drawable.p12, 0));

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

