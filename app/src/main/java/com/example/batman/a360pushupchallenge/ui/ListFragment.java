package com.example.batman.a360pushupchallenge.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.adapter.PushupAdapter;
import com.example.batman.a360pushupchallenge.helper.PushupList;
import com.example.batman.a360pushupchallenge.model.Pushup;

import java.util.ArrayList;

public class ListFragment extends Fragment{

    public static final int LIST_STATS_LOADER = 601;

    private ArrayList<Pushup> pushupList = new ArrayList<>();
    private PushupAdapter pushupAdapter;
    private PushupList mPushupList;

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

        mPushupList = new PushupList();
        mPushupList.preparePushup(pushupList);

        pushupAdapter.notifyDataSetChanged();
        return rootView;
    }




}

