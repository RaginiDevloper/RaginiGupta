package com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.constiutionofindia.MainActivity;
import com.example.constiutionofindia.R;

public class Splash_ScreenActivity extends AppCompatActivity {
    ImageView orange,green , coi;
    TextView txt1,txt2;
    Animation top ,botton,bounce;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.offwhite))));



        orange = findViewById(R.id.orange);
        green = findViewById(R.id.green);
        //txt1 = findViewById(R.id.txtcoi);
        coi = findViewById(R.id.coi);
        txt2 = findViewById(R.id.txtei);

        top = AnimationUtils.loadAnimation(Splash_ScreenActivity.this,R.anim.top_animation) ;
        botton = AnimationUtils.loadAnimation(Splash_ScreenActivity.this,R.anim.bottom_animation);
        bounce = AnimationUtils.loadAnimation(Splash_ScreenActivity.this,R.anim.bounce);


        coi.setAnimation(bounce);
        txt2.setAnimation(bounce);
        orange.setAnimation(top);
        green.setAnimation(botton);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash_ScreenActivity.this, Slide_Swipe_Activity.class);
                startActivity(i);
                finish();
            }
        },3000);

    }

}
