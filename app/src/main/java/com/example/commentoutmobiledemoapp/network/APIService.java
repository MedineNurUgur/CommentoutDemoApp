package com.example.commentoutmobiledemoapp.network;

import com.example.commentoutmobiledemoapp.model.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("v2/59cc13f726000062106b773d")
    Call<List<NewsModel>> getNewsList();
}
