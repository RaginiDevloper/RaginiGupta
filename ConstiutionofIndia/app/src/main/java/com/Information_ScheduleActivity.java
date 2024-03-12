package com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.constiutionofindia.R;

import java.util.Locale;

public class Information_ScheduleActivity extends AppCompatActivity {
    TextToSpeech textToSpeech;
    TextView titleTextView, descriptionTextView;

    ImageView backing, imageView, playbutton, stopbutton, pausebutton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_schedule);

        titleTextView = findViewById(R.id.Scheduletitle);
        descriptionTextView = findViewById(R.id.ScheduleDescription);
        imageView = findViewById(R.id.scheduleimg);

        backing = findViewById(R.id.processback);
        playbutton = findViewById(R.id.Playbutton);
        stopbutton = findViewById(R.id.Stopbutton);
        pausebutton = findViewById(R.id.Pausebutton);

        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");

        titleTextView.setText(title);
        descriptionTextView.setText(description);



        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.UK);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(Information_ScheduleActivity.this, "Language not supported", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Information_ScheduleActivity.this, "Initialization failed", Toast.LENGTH_SHORT).show();
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
                    textToSpeech.speak(descriptionToSpeak, TextToSpeech.QUEUE_FLUSH, null, null);

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
                stopbutton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));

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

}