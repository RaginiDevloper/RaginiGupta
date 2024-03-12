package com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.Schedule_Adapter;
import com.example.constiutionofindia.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class News_ArticlesActivity extends AppCompatActivity {
    RecyclerView rv;
    News_Adapter recyclerAdapter;
//    ArrayList<Pojo_Schedule> pojos
    GifImageView loaer;
    ImageView backimg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_articles);
        loaer = findViewById(R.id.loaer);
        backimg = findViewById(R.id.processback);
        rv = findViewById(R.id.rv);
        getApiCall();
    }
    private void getApiCall(){
        Call<ArrayList<Pojo_NewsArticles>> call = ApiClient.getTryCatchInterface().getnewsData();
        call.enqueue(new Callback<ArrayList<Pojo_NewsArticles>>() {
            @Override
            public void onResponse(Call<ArrayList<Pojo_NewsArticles>> call, Response<ArrayList<Pojo_NewsArticles>> response) {
                if(response.code()==200 && response.body()!=null){
                    recyclerAdapter  = new News_Adapter(News_ArticlesActivity.this,response.body());
                    rv.setLayoutManager(new LinearLayoutManager(News_ArticlesActivity.this));
                    loaer.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(recyclerAdapter);
                }else if(response.code()==401){
                    Toast.makeText(News_ArticlesActivity.this, "Unauthorized",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(News_ArticlesActivity.this, "Error",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Pojo_NewsArticles>> call, Throwable t) {
                Toast.makeText(News_ArticlesActivity.this, "Something went Wrong",Toast.LENGTH_SHORT).show();
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
    public void onBackPressed() {
        super.onBackPressed();
    }


}



