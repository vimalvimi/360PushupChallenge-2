package com.example.batman.a360pushupchallenge.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.helper.PushupList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PopUp extends Activity {

    PushupList pushupList;

    @BindView(R.id.popup_close)
    ImageView close;
    @BindView(R.id.popup_preview)
    ImageView preview;

    String lastPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_popup);
        ButterKnife.bind(this);

        if (getIntent().hasExtra(getString(R.string.pushup_name_preview))) {
            lastPath = getIntent().getStringExtra(getString(R.string.pushup_name_preview));
        }

        pushupList = new PushupList();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int height = dm.heightPixels;
        int width = dm.widthPixels;

        getWindow().setLayout((int) (width * .9), (int) (height * .4));

        Glide.with(this)
                .load(pushupList.getDrawable(lastPath))
                .into(preview);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
