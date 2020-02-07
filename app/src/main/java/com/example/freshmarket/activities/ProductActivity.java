package com.example.freshmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.freshmarket.R;
import com.example.freshmarket.models.Category;
import com.example.freshmarket.models.Product;

import java.util.List;

public class ProductActivity extends AppCompatActivity {

    Category category  ;
    List<Product>  products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);




    }
}
