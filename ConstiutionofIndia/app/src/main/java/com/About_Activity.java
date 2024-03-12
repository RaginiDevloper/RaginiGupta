package com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.constiutionofindia.R;

public class About_Activity extends AppCompatActivity {

    TextView txtcoi,myself,description;
    ImageView imageView;

    Animation slidedown ;
    ImageView backing;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

       // txtcoi = findViewById(R.id.txtcoi);
        myself = findViewById(R.id.txtmysself);
        description = findViewById(R.id.Description);
        imageView = findViewById(R.id.img);

        backing = findViewById(R.id.processback);


        //      slidedown = AnimationUtils.loadAnimation(About_Activity.this,R.anim.slide_down) ;

      //  txtcoi.setAnimation(slidedown);
      //  myself.setAnimation(slidedown);
      //  description.setAnimation(slidedown);
      //  imageView.setAnimation(slidedown);

        backing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
