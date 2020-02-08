package com.example.freshmarket.services;

import com.example.freshmarket.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarketService {

    @GET("task/categories")
    Call<List<Category>> getDataMarket();
}
