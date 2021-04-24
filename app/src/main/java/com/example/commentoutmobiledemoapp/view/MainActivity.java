package com.example.commentoutmobiledemoapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.commentoutmobiledemoapp.R;
import com.example.commentoutmobiledemoapp.adapter.NewsListAdapter;
import com.example.commentoutmobiledemoapp.model.NewsModel;
import com.example.commentoutmobiledemoapp.viewModel.NewsListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView noResult;

    private List<NewsModel> newsList;

    private NewsListAdapter newsListAdapter;
    private NewsListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        noResult = findViewById(R.id.noResultText);

        //configure recyclerview
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        newsListAdapter = new NewsListAdapter(this, newsList);
        recyclerView.setAdapter(newsListAdapter);

        getNewsListFromApi();

    }

    public void getNewsListFromApi(){
        viewModel = ViewModelProviders.of(this).get(NewsListViewModel.class);
        viewModel.getNewsListObserver().observe(this, new Observer<List<NewsModel>>() {
            @Override
            public void onChanged(List<NewsModel> newsModels) {
                if(newsModels != null){
                    newsList = newsModels;
                    newsListAdapter.setNewsList(newsModels);
                    noResult.setVisibility(View.GONE);
                }
                else{
                    noResult.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiGetCall();
    }
}