package com.example.batman.a360pushupchallenge.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.adapter.PushupAdapter;
import com.example.batman.a360pushupchallenge.model.Pushup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        preparePushup();
    }

    private void preparePushup() {
        pushupList.add(new Pushup("Knee", R.drawable.knee_1, 0));
        pushupList.add(new Pushup("Classic", R.drawable.classic_2, 0));
        pushupAdapter.notifyDataSetChanged();
    }

}
