package com.example.freshmarket.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshmarket.R;
import com.example.freshmarket.models.Category;
import com.example.freshmarket.models.Product;
import com.example.freshmarket.utlites.OnProductItemClickListeners;
import com.squareup.picasso.Picasso;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.Pholder> {
    Category category;
    Context context;
    OnProductItemClickListeners mListener;

    public void setOnProductItemClickListeners(OnProductItemClickListeners mListener) {
        this.mListener = mListener;
    }

    public ProductAdapter(Category category, Context context) {
        this.category = category;
        this.context = context;
    }

    @NonNull
    @Override
    public Pholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new Pholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Pholder holder, int position) {
        holder.dataProductBinding(context, category.getProducts().get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return category.getProducts().size();
    }

    class Pholder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productWeight;
        TextView productPrice;

        public Pholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImg);
            productName = itemView.findViewById(R.id.productTitle);
            productWeight = itemView.findViewById(R.id.productWeight);
            productPrice = itemView.findViewById(R.id.ProductPrice);
        }

        void dataProductBinding(Context context, final Product product, final OnProductItemClickListeners mListener) {
            String imageUrl = product.getProductImg();
            Picasso.with(context).load(imageUrl).into(productImage);
            productName.setText(product.getName());
            productWeight.setText(product.getWeight());
            productPrice.setText(product.getPrice());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemProductClick(product);
                }
            });


        }

    }
}

