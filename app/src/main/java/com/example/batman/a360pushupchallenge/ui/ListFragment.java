package com.example.batman.a360pushupchallenge.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class ListFragment extends Fragment {

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

        recyclerView.setAdapter(pushupAdapter);

        preparePushup();
        return rootView;
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
}

