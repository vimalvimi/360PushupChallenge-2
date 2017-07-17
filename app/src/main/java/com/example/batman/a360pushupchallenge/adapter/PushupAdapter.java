package com.example.batman.a360pushupchallenge.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.model.Pushup;
import com.example.batman.a360pushupchallenge.ui.CounterActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PushupAdapter extends RecyclerView.Adapter<PushupAdapter.MyViewHolder> {

    private List<Pushup> pushupList;
    private Context context;

    private String customFont = "Teko-Medium.ttf";
    private Typeface typeface;

    public PushupAdapter(List<Pushup> pushupList, Context context) {
        this.pushupList = pushupList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pushup, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Pushup pushup = pushupList.get(position);

        typeface = Typeface.createFromAsset(context.getAssets(), customFont);
        holder.name.setTypeface(typeface);

        Glide.with(context)
                .load(pushup.getImage())
                .into(holder.image);
        holder.name.setText(pushup.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, CounterActivity.class);
                intent.putExtra(context.getString(R.string.extra_last_path), pushup.getUri_path());
                intent.putExtra(context.getString(R.string.extra_type_title), pushup.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pushupList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_pushup_image)
        ImageView image;
        @BindView(R.id.list_pushup_name)
        TextView name;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
