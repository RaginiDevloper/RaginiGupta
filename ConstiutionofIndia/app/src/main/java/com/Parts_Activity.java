package com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Pojo_Parts;
import com.example.constiutionofindia.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Parts_Activity extends AppCompatActivity implements Parts_Adapter.OnPartItemClick, OnClickAdapter {

    RecyclerView rv, recyclerView;
    Parts_Adapter recyclerAdapter;
    Article_Adapter article_adapter;

    GifImageView loader;

    TextView textView;
    ImageView backimg;

    ImageView noDataImageView; // Add this line


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);

        recyclerView = findViewById(R.id.recycleview);
        loader = findViewById(R.id.loaer);
        backimg = findViewById(R.id.processback);
        rv = findViewById(R.id.Parts_recy);
        textView = findViewById(R.id.smallDescription);
        noDataImageView = findViewById(R.id.noDataImage);


        getApiCall();
    }

    private void getApiCall() {
        Call<ArrayList<Pojo_Parts>> call = ApiClient.getTryCatchInterface().getpartData();
        call.enqueue(new Callback<ArrayList<Pojo_Parts>>() {
            @Override
            public void onResponse(Call<ArrayList<Pojo_Parts>> call, Response<ArrayList<Pojo_Parts>> response) {
                if (response.code() == 200 && response.body() != null) {
                    recyclerAdapter = new Parts_Adapter(Parts_Activity.this, response.body(), Parts_Activity.this);

                    rv.setLayoutManager(new LinearLayoutManager(Parts_Activity.this, LinearLayoutManager.HORIZONTAL, false));

                    loader.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);

                    rv.setAdapter(recyclerAdapter);
                } else if (response.code() == 401) {
                    Toast.makeText(Parts_Activity.this, "Unauthorized", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Parts_Activity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pojo_Parts>> call, Throwable t) {
                Toast.makeText(Parts_Activity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });


        backimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onPartItemClick(Pojo_Parts part) {
        Toast.makeText(this, "Clicked on part: " + part.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onPartItemClick(String id, String smallDescription) {
        textView.setText(smallDescription);
        loadBelowData(id);
    }

    private void loadBelowData(String id) {

            Call<ArrayList<Pojo_Article>> call = ApiClient.getTryCatchInterface().getarticleData(Integer.parseInt(id));
            call.enqueue(new Callback<ArrayList<Pojo_Article>>() {

                @Override
                public void onResponse(Call<ArrayList<Pojo_Article>> call, Response<ArrayList<Pojo_Article>> response) {
                    if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                        article_adapter = new Article_Adapter(Parts_Activity.this, response.body());
                        recyclerView.setLayoutManager(new LinearLayoutManager(Parts_Activity.this));
                        loader.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        recyclerView.setAdapter(article_adapter);
                        noDataImageView.setVisibility(View.GONE); // Hide no data image
                    } else {
                        // No data available, show a message and the image
                        noDataImageView.setVisibility(View.VISIBLE); // Show no data image
                        loader.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Pojo_Article>> call, Throwable t) {
                    // Failure case, show a message and the image
                    noDataImageView.setVisibility(View.VISIBLE); // Show no data image
                    loader.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.GONE);
                }
            });
        }
}







