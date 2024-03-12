package com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.constiutionofindia.MainActivity;
import com.example.constiutionofindia.R;

public class Slide_Swipe_Activity extends AppCompatActivity {

    ViewPager mSliderviewpager;
    LinearLayout mDotLayout;
    Button backbtn, nextbtn,skipbtn;

    TextView[] dots;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_swipe);

        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.white))));


        backbtn = findViewById(R.id.backbtn);
        nextbtn = findViewById(R.id.nextbtn);
        skipbtn = findViewById(R.id.skipButton);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getitem(0) > 0){

                    mSliderviewpager.setCurrentItem(getitem(-1),true);
                }

            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (getitem(0) < 2)
                    mSliderviewpager.setCurrentItem(getitem(1),true);
                else {
                    Intent i = new Intent(Slide_Swipe_Activity.this, Parliments_Activity.class);
                    startActivity(i);
                    finish();
                }

            }
        });

        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Slide_Swipe_Activity.this,Parliments_Activity.class);
                startActivity(i);
                finish();

                }

        });

        mSliderviewpager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicate_layout);


        viewPagerAdapter = new ViewPagerAdapter(this);

        mSliderviewpager.setAdapter(viewPagerAdapter);

        setUpindicator(0);
        mSliderviewpager.addOnPageChangeListener(viewListener);
    }

    public void setUpindicator(int position){

        dots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0 ; i < dots.length; i++){

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpindicator(position);

            if (position > 0){
                backbtn.setVisibility(View.VISIBLE);
            }else {
                backbtn.setVisibility(View.INVISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private  int getitem(int i) {
        return mSliderviewpager.getCurrentItem() + i;
    }
}