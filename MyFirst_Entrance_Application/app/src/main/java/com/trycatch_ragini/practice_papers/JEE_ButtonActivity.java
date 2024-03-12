package com.trycatch_ragini.practice_papers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.trycatch_ragini.pratice_paper.R;


public class JEE_ButtonActivity extends AppCompatActivity {

    TextView txt17, txt16, txt15, txt14, txt13, txt12, txt11, txt10, txt9, txt8, txt7, txt6, txt5, txt4, txt3, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_button);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.lightblack))));


        txt17 = findViewById(R.id.year17);
        txt16 = findViewById(R.id.year16);
        txt15 = findViewById(R.id.year15);
        txt14 = findViewById(R.id.year14);
        txt13 = findViewById(R.id.year13);
        txt12 = findViewById(R.id.year12);
        txt11 = findViewById(R.id.year11);
        txt10 = findViewById(R.id.year10);
        txt9 = findViewById(R.id.year9);
        txt8 = findViewById(R.id.year8);
        txt7 = findViewById(R.id.year7);
        txt6 = findViewById(R.id.year6);
        txt5 = findViewById(R.id.year5);
        txt4 = findViewById(R.id.year4);
        txt3 = findViewById(R.id.year3);
        txt2 = findViewById(R.id.year2);


        txt17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2017_Activity.class);
                startActivity(i);

            }
        });

        txt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2016_Activity.class);
                startActivity(i);

            }
        });


        txt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2015_Activity.class);
                startActivity(i);

            }
        });



        txt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2014_Activity.class);
                startActivity(i);

            }
        });

        txt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2013_Activity.class);
                startActivity(i);

            }
        });

        txt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2012_Activity.class);
                startActivity(i);

            }
        });

        txt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2011_Activity.class);
                startActivity(i);

            }
        });

        txt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2010_Activity.class);
                startActivity(i);

            }
        });

        txt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2009_Activity.class);
                startActivity(i);

            }
        });


        txt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2008_Activity.class);
                startActivity(i);

            }
        });


        txt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2007_Activity.class);
                startActivity(i);

            }
        });

        txt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2006_Activity.class);
                startActivity(i);

            }
        });

        txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2005_Activity.class);
                startActivity(i);

            }
        });


        txt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2004_Activity.class);
                startActivity(i);

            }
        });


        txt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2003_Activity.class);
                startActivity(i);

            }
        });


        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(JEE_ButtonActivity.this, View2002_Activity.class);
                startActivity(i);

            }
        });


    }
}