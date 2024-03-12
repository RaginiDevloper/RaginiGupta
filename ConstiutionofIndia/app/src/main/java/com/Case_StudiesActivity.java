package com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.constiutionofindia.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Case_StudiesActivity extends AppCompatActivity {


    RecyclerView rv;
    Adapter_casestudies recyclerAdapter;
    GifImageView loaer;
    ImageView backimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_studies);
        loaer = findViewById(R.id.loaer);
        backimg = findViewById(R.id.processback);
        rv = findViewById(R.id.caserv);
        getApiCall();
    }
    private void getApiCall(){
        Call<ArrayList<Pojo_CaseStudy>> call = ApiClient.getTryCatchInterface().getcasestudiessData();
        call.enqueue(new Callback<ArrayList<Pojo_CaseStudy>>() {
            @Override
            public void onResponse(Call<ArrayList<Pojo_CaseStudy>> call, Response<ArrayList<Pojo_CaseStudy>> response) {
                if(response.code()==200 && response.body()!=null){
                    recyclerAdapter  = new Adapter_casestudies(Case_StudiesActivity.this,response.body());
                    rv.setLayoutManager(new LinearLayoutManager(Case_StudiesActivity.this));
                    loaer.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);
                    rv.setAdapter(recyclerAdapter);
                }else if(response.code()==401){
                    Toast.makeText(Case_StudiesActivity.this, "Unauthorized",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Case_StudiesActivity.this, "Error",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<Pojo_CaseStudy>> call, Throwable t) {
                Toast.makeText(Case_StudiesActivity.this, "Something went Wrong",Toast.LENGTH_SHORT).show();
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

