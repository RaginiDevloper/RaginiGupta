package com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.constiutionofindia.R;

public class Information_Case_Studies extends AppCompatActivity {
    TextView titleTextView, descriptionTextView;
    ImageView backButton, noDataImageView , bookmarks;

    SharedPreferences sharedPreferences;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_case_studies);

        titleTextView = findViewById(R.id.titlecase);
        descriptionTextView = findViewById(R.id.smallDescription);
        backButton = findViewById(R.id.processback);
        noDataImageView = findViewById(R.id.noDataImage); // Add this line

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        if (title != null && !title.isEmpty() && description != null && !description.isEmpty()) {
            // Data is available, display it
            titleTextView.setText(title);
            descriptionTextView.setText(description);
            noDataImageView.setVisibility(View.GONE); // Hide no data image
        } else {
            // No data available, show a message and the image
            titleTextView.setText("No Data Available");
            descriptionTextView.setText("Data will be updated soon.");
            noDataImageView.setVisibility(View.VISIBLE); // Show no data image
        }


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
