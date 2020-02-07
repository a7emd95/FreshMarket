package com.example.freshmarket.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshmarket.R;
import com.example.freshmarket.adpters.CategoryAdpter;
import com.example.freshmarket.models.Category;
import com.example.freshmarket.utlites.OnItemClickListeners;
import com.example.freshmarket.viewmodel.MainViewModel;

import java.util.List;

import static com.example.freshmarket.utlites.Constant.CATEGORY_DATA;


public class MainActivity extends AppCompatActivity implements OnItemClickListeners {
    CategoryAdpter adapter;
    MainViewModel mViewModel;
    RecyclerView recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewCategory = findViewById(R.id.catagroyListView);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.getCategories();
        observeViewModel();

    }

    private void observeViewModel() {

        mViewModel.categoriesLiveData.observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {

                adapter = new CategoryAdpter(MainActivity.this, categories);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
                recyclerViewCategory.setLayoutManager(layoutManager);
                recyclerViewCategory.setAdapter(adapter);
                adapter.setOnItemClickListener(MainActivity.this);
            }
        });
    }


    @Override
    public void onItemClick(Category category) {
        Intent intent = new Intent(this, ProductActivity.class);
        intent.putExtra(CATEGORY_DATA, category);
        startActivity(intent);

    }

}

