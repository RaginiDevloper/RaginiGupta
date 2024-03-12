package com.trycatch_ragini.practice_papers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.trycatch_ragini.pratice_paper.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JeeMains_Activity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerAdapter recyclerAdapter;
    ArrayList<Pojo> pojos;

    GifImageView loaer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jee_mains);

        loaer = findViewById(R.id.loaer);

        rv = findViewById(R.id.recy);
        getApiCall(1,2);

    }
    private void getApiCall(int cat_id, int year){
        Call<ArrayList<Pojo>> call = ApiClient.getTryCatchInterface().getData(cat_id, year);
        call.enqueue(new Callback<ArrayList<Pojo>>() {
            @Override
            public void onResponse(Call<ArrayList<Pojo>> call, Response<ArrayList<Pojo>> response) {
                if(response.code()==200 && response.body()!=null){
                    recyclerAdapter  = new RecyclerAdapter(JeeMains_Activity.this,response.body());
                    rv.setLayoutManager(new LinearLayoutManager(JeeMains_Activity.this));
                    loaer.setVisibility(View.GONE);

                    rv.setAdapter(recyclerAdapter);

                }else if(response.code()==401){
                    Toast.makeText(JeeMains_Activity.this, "Unauthorized",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(JeeMains_Activity.this, "Error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Pojo>> call, Throwable t) {
                Toast.makeText(JeeMains_Activity.this, "Something went Wrong",Toast.LENGTH_SHORT).show();
            }
        });

    }
}