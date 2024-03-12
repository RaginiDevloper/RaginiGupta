package com.trycatch_ragini.practice_papers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;


import com.trycatch_ragini.pratice_paper.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NEET_Activity extends AppCompatActivity {

    RecyclerView rv;
    NEET_Adapter recyclerAdapter;
    ArrayList<NEET_Pojo> pojos;

    GifImageView loaer;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neet);
        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.lightblack))));




        rv = findViewById(R.id.recy);
        getApiCall(1,2);

    }
    private void getApiCall(int cat_id, int year){
        Call<ArrayList<NEET_Pojo>> call = ApiClient.getTryCatchInterface().newgetData(cat_id, year);
        call.enqueue(new Callback<ArrayList<NEET_Pojo>>() {
            @Override
            public void onResponse(Call<ArrayList<NEET_Pojo>> call, Response<ArrayList<NEET_Pojo>> response) {
                if(response.code()==200 && response.body()!=null){
                    recyclerAdapter  = new NEET_Adapter(NEET_Activity.this,response.body());
                    rv.setLayoutManager(new LinearLayoutManager(NEET_Activity.this));
                    rv.setAdapter(recyclerAdapter);
                }else if(response.code()==401){
                    Toast.makeText(NEET_Activity.this, "Unauthorized",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(NEET_Activity.this, "Error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<NEET_Pojo>> call, Throwable t) {
                Toast.makeText(NEET_Activity.this, "Something went Wrong",Toast.LENGTH_SHORT).show();
            }
        });



    }
}