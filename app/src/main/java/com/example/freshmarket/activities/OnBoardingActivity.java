package com.example.freshmarket.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.freshmarket.R;
import com.example.freshmarket.adpters.SliderAdapter;

public class OnBoardingActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private LinearLayout mDotsLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    Handler handler ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_bording);

        mViewPager = findViewById(R.id.slideViewPager);
        mDotsLayout = findViewById(R.id.dots);
        sliderAdapter = new SliderAdapter(this);
        mViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        mViewPager.addOnPageChangeListener(viewListener);
    }

    public void addDotsIndicator(int position) {
        mDots = new TextView[3];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(android.R.color.darker_gray));
            mDotsLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

            if (position   == mDots.length - 1) {
                handler = new Handler();
                 handler.postDelayed(new Runnable() {
                     @Override
                     public void run() {
                         Intent intent = new Intent(OnBoardingActivity.this, MainActivity.class);
                         startActivity(intent);
                         finish();

                     }
                 },800);



            }
        }

        @Override
        public void onPageScrollStateChanged(int state) { }
    };
}