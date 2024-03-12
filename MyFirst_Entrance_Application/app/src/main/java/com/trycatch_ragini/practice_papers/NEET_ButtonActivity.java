package com.trycatch_ragini.practice_papers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.trycatch_ragini.pratice_paper.R;


public class NEET_ButtonActivity extends AppCompatActivity {

    TextView neet18,neet17,neet16,neet15,neet14;
    CardView cardView1,cardView2,cardView3,cardView4,cardView5;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neet_button);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.lightblack))));


        neet18= findViewById(R.id.neet18);
        neet17 = findViewById(R.id.neet17);
        neet16 = findViewById(R.id.neet16);
        neet15 = findViewById(R.id.neet15);
        neet14 = findViewById(R.id.neet14);

        cardView1 = findViewById(R.id.cardview1);
        cardView2 = findViewById(R.id.cardview2);
        cardView3 = findViewById(R.id.cardview3);
        cardView4 = findViewById(R.id.cardview4);
        cardView5 = findViewById(R.id.cardview5);

        neet18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, neet2018_Activity.class);
                startActivity(i);

            }
        });

        neet17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2017_Activity.class);
                startActivity(i);

            }
        });

        neet16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2016_Activity.class);
                startActivity(i);

            }
        });

        neet15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2015_Activity.class);
                startActivity(i);

            }
        });

        neet14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2014_Activity.class);
                startActivity(i);

            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, neet2018_Activity.class);
                startActivity(i);

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2017_Activity.class);
                startActivity(i);

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2016_Activity.class);
                startActivity(i);

            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2015_Activity.class);
                startActivity(i);

            }
        });

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NEET_ButtonActivity.this, Neet2014_Activity.class);
                startActivity(i);

            }
        });










    }
}