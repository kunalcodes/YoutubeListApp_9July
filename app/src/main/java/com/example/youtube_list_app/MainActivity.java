package com.example.youtube_list_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    private ArrayList<String> videoList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildRecyclerViewData();
        setRecyclerViewAdapter();
    }


    private void setRecyclerViewAdapter() {
        VideoAdapter videoAdapter = new VideoAdapter(videoList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(videoAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /* generating dummy list for recycler view
    if we do this step after setting the adapter, we have to call
    notify dataset changed method
     */
    private void buildRecyclerViewData() {
        for (int i=0; i<10; i++){
            videoList.add("https://www.youtube.com/watch?v=LIF5BnugxYM");
        }
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }


    /* interface method called form view holder with the link url and opened through
    implicit intent
    */
    @Override
    public void onItemClicked(int position, String s) {
        Intent openVideo = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
        startActivity(openVideo);
    }
}