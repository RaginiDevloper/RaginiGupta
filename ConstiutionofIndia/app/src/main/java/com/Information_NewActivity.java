package com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.constiutionofindia.R;

public class Information_NewActivity extends AppCompatActivity {

    TextView titleTextView, dateTextView, descriptionTextView;
    ImageView backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_new);

        titleTextView = findViewById(R.id.titlenews);
        dateTextView = findViewById(R.id.date);
        descriptionTextView = findViewById(R.id.smallDescription);
        backButton = findViewById(R.id.processback);



        String date = getIntent().getStringExtra("date");
        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        titleTextView.setText(title);
        dateTextView.setText(date);
        descriptionTextView.setText(description);

        backButton.setOnClickListener(new View.OnClickListener() {
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
