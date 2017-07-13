package com.example.batman.a360pushupchallenge.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.batman.a360pushupchallenge.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CounterActivity extends AppCompatActivity {

    private String currentPushupType;

    private int livePushupCounter = 0;
    private int highScore;

    @BindView(R.id.counter_count_button)
    TextView counterButton;
    @BindView(R.id.counter_back_button)
    TextView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);

        if (getIntent().hasExtra(getString(R.string.extra_type_pushup))) {
            currentPushupType = getIntent().getStringExtra(getString(R.string.extra_type_pushup));
            setTitle(currentPushupType);
        }

        counterButton.setText(String.valueOf(livePushupCounter));

        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushupCounter();
            }
        });
    }

    private void pushupCounter() {
        livePushupCounter++;
        counterButton.setText(String.valueOf(livePushupCounter));
    }
}
