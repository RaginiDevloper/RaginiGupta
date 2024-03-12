package com.trycatch_ragini.practice_papers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.trycatch_ragini.pratice_paper.R;

public class JeeAdvance_Activity extends AppCompatActivity {


TextView paperA,paperB;

CardView cardView1,cardView2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_advance);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.lightblack))));


        paperA = findViewById(R.id.paperA);
        paperB = findViewById(R.id.paperB);
        cardView1 = findViewById(R.id.cardview1);
        cardView2 = findViewById(R.id.cardview2);

        paperA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JeeAdvance_Activity.this, PaperA_Activity.class);
                startActivity(i);

            }
        });

        paperB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JeeAdvance_Activity.this, PaperB_Activity.class);
                startActivity(i);

            }
        });

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JeeAdvance_Activity.this, PaperA_Activity.class);
                startActivity(i);

            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JeeAdvance_Activity.this, PaperA_Activity.class);
                startActivity(i);

            }
        });






    }
}