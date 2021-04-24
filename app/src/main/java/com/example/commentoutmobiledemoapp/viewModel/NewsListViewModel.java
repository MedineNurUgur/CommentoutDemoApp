package com.example.commentoutmobiledemoapp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.commentoutmobiledemoapp.model.NewsModel;
import com.example.commentoutmobiledemoapp.network.APIService;
import com.example.commentoutmobiledemoapp.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsListViewModel extends ViewModel {

    private MutableLiveData<List<NewsModel>> newsList;

    public NewsListViewModel(){
        newsList = new MutableLiveData<>();

    }

    public MutableLiveData<List<NewsModel>> getNewsListObserver(){

        return  newsList;
    }

    public void makeApiGetCall(){
        APIService apiService = RetrofitInstance.getClient().create(APIService.class);
        Call<List<NewsModel>> call = apiService.getNewsList();
        call.enqueue(new Callback<List<NewsModel>>() {
            @Override
            public void onResponse(Call<List<NewsModel>> call, Response<List<NewsModel>> response) {
                newsList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<NewsModel>> call, Throwable t) {
                newsList.postValue(null);
            }
        });
    }
}
