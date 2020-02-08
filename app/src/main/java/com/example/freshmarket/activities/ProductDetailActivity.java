package com.example.freshmarket.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.freshmarket.R;
import com.example.freshmarket.models.Product;

import static com.example.freshmarket.utlites.Constant.PRODUCT_DATA;

public class ProductDetailActivity extends AppCompatActivity {
    Product product;
    TextView productTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        dataProductIntent();
        updateUi();
    }
    void dataProductIntent() { product = getIntent().getParcelableExtra(PRODUCT_DATA);}
    void updateUi() {
        productTitle = findViewById(R.id.productdetail);
        productTitle.setText(product.getName());
    }
}
