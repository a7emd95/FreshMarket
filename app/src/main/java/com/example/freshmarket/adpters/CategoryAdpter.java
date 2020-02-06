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
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class CategoryAdpter extends RecyclerView.Adapter<CategoryAdpter.Holder>{

     List<Category> categories ;
     Context context;

    public CategoryAdpter( Context context, List<Category> categories) {
        this.context = context;
        this.categories =  categories;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.categroy_item , parent , false );
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.onBinding(context, categories.get(position));

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

  public static   class Holder extends RecyclerView.ViewHolder{

     ImageView catagroyImage;
     TextView catagroyName;

      public Holder(@NonNull View itemView) {
          super(itemView);
          catagroyImage = itemView.findViewById(R.id.catagroyImg);
          catagroyName = itemView.findViewById(R.id.catagroyName);
      }

      void onBinding(Context context , Category category){
          String url = category.getCategoryImg();
        Picasso.with(context).load(url).into(catagroyImage);

          catagroyName.setText(category.getName());
      }
  }


    }

