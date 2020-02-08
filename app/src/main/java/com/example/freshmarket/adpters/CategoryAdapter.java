package com.example.freshmarket.adpters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshmarket.R;
import com.example.freshmarket.models.Category;
import com.example.freshmarket.utlites.OnItemClickListeners;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Holder> {

    List<Category> categories;
    Context context;
    OnItemClickListeners mListener;



    public void setOnItemClickListener(OnItemClickListeners mListener) {
        this.mListener = mListener;
    }

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;

    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.categroy_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.onBinding(context, categories.get(position), mListener);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView categoryName;

        public Holder(@NonNull View itemView) {
            super(itemView);
            categoryImage = itemView.findViewById(R.id.catagroyImg);
            categoryName = itemView.findViewById(R.id.catagroyName);
        }

        void onBinding(Context context, final Category category, final OnItemClickListeners mListener) {
            String url = category.getCategoryImg();
            Picasso.with(context).load(url).into(categoryImage);
            categoryName.setText(category.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(category);
                }
            });
        }
    }


}

