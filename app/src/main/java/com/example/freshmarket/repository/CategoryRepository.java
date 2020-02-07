package com.example.freshmarket.repository;

import com.example.freshmarket.models.Category;
import com.example.freshmarket.services.MarketService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.freshmarket.utlites.Constant.BASE_URL;

public class CategoryRepository {
    private Retrofit retrofit;
    private MarketService marketService;
    private CategoryCallBack categoryCallBack;


    public CategoryRepository(CategoryCallBack categoryCallBack){
        this.categoryCallBack = categoryCallBack;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketService = retrofit.create(MarketService.class);

    }

    public void getCategories(){
        Call<List<Category>> marketApiResponse = marketService.getDataMarket();
        marketApiResponse.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                categoryCallBack.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                categoryCallBack.onError(t);
            }
        });
    }

}
