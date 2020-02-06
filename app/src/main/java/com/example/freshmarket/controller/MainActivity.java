package com.example.freshmarket.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshmarket.R;
import com.example.freshmarket.adpters.CategoryAdpter;
import com.example.freshmarket.models.Category;
import com.example.freshmarket.services.marketService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
  //  RecyclerView catagroyListView;
    CategoryAdpter adpter;
    List<Category> categories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://5bcce576cf2e850013874767.mockapi.io/task/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        marketService service = retrofit.create(marketService.class);
        Call<List<Category>> marketApiResponse = service.getdataMarket();
        marketApiResponse.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                categories = response.body();
                RecyclerView recyclerViewCatagry = findViewById(R.id.catagroyListView);
                adpter = new CategoryAdpter(MainActivity.this, categories);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this , 2);
                recyclerViewCatagry.setLayoutManager(layoutManager);
                recyclerViewCatagry.setAdapter(adpter);





            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
            }
        });


    }
}
