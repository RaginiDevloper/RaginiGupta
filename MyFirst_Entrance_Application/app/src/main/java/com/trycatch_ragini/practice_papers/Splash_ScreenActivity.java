package com.trycatch_ragini.practice_papers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.trycatch_ragini.pratice_paper.R;


public class Splash_ScreenActivity extends AppCompatActivity {

    ImageView imagetree;
    TextView txt1,txt2,txt3;
    Animation top,bottom,zoomout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.lightblack))));


        imagetree = findViewById(R.id.imagetree);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        top = AnimationUtils.loadAnimation(Splash_ScreenActivity.this,R.anim.top_animation) ;
        bottom = AnimationUtils.loadAnimation(Splash_ScreenActivity.this,R.anim.bottom_animation);
        zoomout = AnimationUtils.loadAnimation(Splash_ScreenActivity.this,R.anim.zoom_out);


        txt1.setAnimation(top);
        txt2.setAnimation(top);
        txt3.setAnimation(bottom);
        imagetree.setAnimation(zoomout);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_ScreenActivity.this, Subjects_Activity.class);
                startActivity(i);
                finish();
            }
        },3000);

    }
}