package com.example.batman.a360pushupchallenge.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.batman.a360pushupchallenge.R;
import com.example.batman.a360pushupchallenge.model.Pushup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PushupAdapterWidget extends RecyclerView.Adapter<PushupAdapterWidget.MyViewHolder> {

    private static final String TAG = "PushupAdapter";

    private List<Pushup> pushupList;
    private Context context;

    private String customFont = "Teko-Medium.ttf";
    private Typeface typeface;

    private ClickListener mClickListener;

    public PushupAdapterWidget(List<Pushup> pushupList, Context context, ClickListener clickListener) {
        this.pushupList = pushupList;
        this.context = context;
        mClickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pushup, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Pushup pushup = pushupList.get(position);

        typeface = Typeface.createFromAsset(context.getAssets(), customFont);

        holder.name.setTypeface(typeface);

        Glide.with(context)
                .load(pushup.getImage())
                .into(holder.image);

        holder.name.setText(pushup.getName());
    }

    @Override
    public int getItemCount() {
        return pushupList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.list_pushup_image)
        ImageView image;
        @BindView(R.id.list_pushup_name)
        TextView name;

        MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {
                mClickListener.itemClicked(view, getAdapterPosition());
            }
        }
    }

    public interface ClickListener {
        void itemClicked(View view, int position);
    }
}
