package com.example.constiutionofindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ApiClient;
import com.Article_Adapter;
import com.Pojo_Article;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.ArrayList;

public class Information_PartsActivity extends AppCompatActivity {

    TextView textView;
    ImageView backing;
    RecyclerView rv;
    Article_Adapter recyclerAdapter;
    GifImageView loader;
    ImageView noDataImageView; // Add this line

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_parts);

        noDataImageView = findViewById(R.id.noDataImage); // Add this line

        textView = findViewById(R.id.smallDescription);
        backing = findViewById(R.id.processback);
        loader = findViewById(R.id.loaer);
        rv = findViewById(R.id.article_recy);

        String id = getIntent().getStringExtra("partId");
        getApiCall(Integer.parseInt(id));

        String extraDataKey = "yourExtraDataKey";
        String extraData = getIntent().getStringExtra(extraDataKey);
        textView.setText(extraData);

        backing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getApiCall(int cat_id) {
        Call<ArrayList<Pojo_Article>> call = ApiClient.getTryCatchInterface().getarticleData(cat_id);
        call.enqueue(new Callback<ArrayList<Pojo_Article>>() {

            @Override
            public void onResponse(Call<ArrayList<Pojo_Article>> call, Response<ArrayList<Pojo_Article>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    recyclerAdapter = new Article_Adapter(Information_PartsActivity.this, response.body());
                    rv.setLayoutManager(new LinearLayoutManager(Information_PartsActivity.this));
                    loader.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(recyclerAdapter);
                    noDataImageView.setVisibility(View.GONE); // Hide no data image
                } else {
                    // No data available, show a message and the image
                    noDataImageView.setVisibility(View.VISIBLE); // Show no data image
                    loader.setVisibility(View.GONE);
                    rv.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pojo_Article>> call, Throwable t) {
                // Failure case, show a message and the image
                noDataImageView.setVisibility(View.VISIBLE); // Show no data image
                loader.setVisibility(View.GONE);
                rv.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
