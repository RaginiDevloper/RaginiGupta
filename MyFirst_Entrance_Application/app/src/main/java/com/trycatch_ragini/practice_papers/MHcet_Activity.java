package com.trycatch_ragini.practice_papers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.trycatch_ragini.pratice_paper.R;


public class MHcet_Activity extends AppCompatActivity {

    TextView cet2018 , cet2017;
    CardView cardView1, cardView2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mhcet);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.lightblack))));


        cet2018 = findViewById(R.id.cet18);
        cet2017 = findViewById(R.id.cet17);
        cardView1 = findViewById(R.id.cardview1);
        cardView2 = findViewById(R.id.cardview2);

        cet2018.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MHcet_Activity.this, "data not found", Toast.LENGTH_SHORT).show();
            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MHcet_Activity.this,"Data Not Found" ,Toast.LENGTH_SHORT).show();

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MHcet_Activity.this,"Data Not Found" ,Toast.LENGTH_SHORT).show();

            }
        });


    }
}