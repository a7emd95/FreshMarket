package com.example.freshmarket.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.freshmarket.R;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater ;

    public SliderAdapter(Context context) {   this.context = context;   }

    public int[] slideImages = {
            R.drawable.fragmentone,
            R.drawable.fragmenttwo,
            R.drawable.fragmentthree,
    };

    public String[] slideHeading = {
            "fresh products  here",
            "fresh products  here",
            "delivry every where "
    };

    public String[] slideDescription = {
            "The tomato is the edible, often red, berry of the plant Solanum lycopersicum",
            "The tomato is the edible, often red, berry of the plant Solanum lycopersicum",
            "The tomato is the edible, often red, berry of the plant Solanum lycopersicum"
    };

    @Override
    public int getCount() { return slideHeading.length; }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==  object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container , false);

        ImageView slideImageView =  view.findViewById(R.id.slide_image);
        TextView slideHeadingView = view.findViewById(R.id.slide_heading);
        TextView slideDescriptionView = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slideImages[position]);
        slideHeadingView.setText(slideHeading[position]);
        slideDescriptionView.setText(slideDescription[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
