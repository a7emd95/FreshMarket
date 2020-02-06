package com.example.freshmarket.services;

import com.example.freshmarket.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface marketService {

    @GET("https://5bcce576cf2e850013874767.mockapi.io/task/categories")
    Call<List<Category>> getdataMarket();
}
