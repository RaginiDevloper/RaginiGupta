package com;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.constiutionofindia.R;

import java.util.ArrayList;
import java.util.Locale;

public class Information_AmendmentActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;

    TextView  titleTextView ,  descriptionTextView;
    ImageView imageView, playbutton, pausebutton, stopbutton;

    ImageView backing ,noDataImageView;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_amendment);


        noDataImageView = findViewById(R.id.noDataImage); // Add this line

        titleTextView = findViewById(R.id.Amendmenttitle);
        descriptionTextView = findViewById(R.id.AmendmentDescription);

        imageView = findViewById(R.id.scheduleimg);
        playbutton = findViewById(R.id.Playbutton);
        pausebutton = findViewById(R.id.Pausebutton);
        stopbutton = findViewById(R.id.Stopbutton);
        backing = findViewById(R.id.processback);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        titleTextView.setText(title);
        descriptionTextView.setText(description);

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



        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.UK);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(Information_AmendmentActivity.this, "Language not supported", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Information_AmendmentActivity.this, "Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titleToSpeak = titleTextView.getText().toString().trim();
                String descriptionToSpeak = descriptionTextView.getText().toString().trim();

                if (!titleToSpeak.isEmpty()) {
                    textToSpeech.speak(titleToSpeak, TextToSpeech.QUEUE_FLUSH, null, null);
                }
                if (!descriptionToSpeak.isEmpty()) {
                    textToSpeech.speak(descriptionToSpeak, TextToSpeech.QUEUE_ADD, null, null);
                }
                playbutton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

            }
        });


        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textToSpeech.isSpeaking()) {
                    textToSpeech.stop();
                }
                stopbutton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

            }
        });


        pausebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textToSpeech.isSpeaking()) {
                    textToSpeech.stop();
                }
                pausebutton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

            }
        });


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
