package com.example.freshmarket.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.freshmarket.R;
import com.example.freshmarket.adpters.ProductAdapter;
import com.example.freshmarket.models.Category;
import com.example.freshmarket.models.Product;
import com.example.freshmarket.utlites.OnProductItemClickListeners;
import com.squareup.picasso.Picasso;

import static com.example.freshmarket.utlites.Constant.CATEGORY_DATA;
import static com.example.freshmarket.utlites.Constant.PRODUCT_DATA;

public class ProductActivity extends AppCompatActivity  implements OnProductItemClickListeners {
    Category category  ;
    ProductAdapter adapter;
    RecyclerView recyclerViewProduct ;
    ImageView categoryImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        dataIntent();

        categoryImage = findViewById(R.id.catagroyImgProduct);
        Picasso.with(this).load(category.getCategoryImg()).into(categoryImage);
        recyclerViewProduct = findViewById(R.id.productList);
        setAdapter();
    }
    void dataIntent(){
        category = getIntent().getParcelableExtra(CATEGORY_DATA);
    }
    void setAdapter(){
        adapter = new ProductAdapter(category, this);
        RecyclerView.LayoutManager layoutManager =  new GridLayoutManager(this , 2);
        recyclerViewProduct.setLayoutManager(layoutManager);
        recyclerViewProduct.setAdapter(adapter);
        adapter.setOnProductItemClickListeners(this);
    }
    @Override
    public void onItemProductClick(Product product) {
        Intent intent = new Intent(this , ProductDetailActivity.class);
        intent.putExtra(PRODUCT_DATA, product);
        startActivity(intent);
    }
}


