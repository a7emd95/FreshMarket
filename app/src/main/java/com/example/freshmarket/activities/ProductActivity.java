package com.example.freshmarket.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.freshmarket.R;
import com.example.freshmarket.adpters.ProductAdapter;
import com.example.freshmarket.models.Category;
import com.squareup.picasso.Picasso;

import static com.example.freshmarket.utlites.Constant.CATEGORY_DATA;

public class ProductActivity extends AppCompatActivity {
    Category category  ;
    ProductAdapter adapter;
    RecyclerView recyclerViewProduct ;
    ImageView categoryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        DataIntent();
        categoryImage = findViewById(R.id.catagroyImgProduct);
        Picasso.with(this).load(category.getCategoryImg()).into(categoryImage);
        recyclerViewProduct = findViewById(R.id.productList);
        setAdapter();



    }

    void DataIntent(){
        category = getIntent().getParcelableExtra(CATEGORY_DATA);
    }

    void setAdapter(){
        adapter = new ProductAdapter(category, this);
        RecyclerView.LayoutManager layoutManager =  new GridLayoutManager(this , 2);
        recyclerViewProduct.setLayoutManager(layoutManager);
        recyclerViewProduct.setAdapter(adapter);


    }
}


