package com.example.youtube_list_app;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvVideoLink;
    private ItemClickListener itemClickListener;
    private CardView mCvCardView;

    public VideoViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvVideoLink = itemView.findViewById(R.id.tvLink);
        mCvCardView = itemView.findViewById(R.id.cvCardView);
    }

    //setting the data and passing the url to activity on click
    public void setData(String s) {
        mTvVideoLink.setText(s);
        mCvCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(),s);
            }
        });

    }
}
