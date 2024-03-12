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

public class Amendment_Activity extends AppCompatActivity {

    RecyclerView rv;
    Amendment_Adapter recyclerAdapter;

    GifImageView loaer;

    ImageView backimg;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amendment);

        loaer = findViewById(R.id.loaer);
        backimg = findViewById(R.id.processback);


        rv = findViewById(R.id.amendment_recy);
        getApiCall();

    }



    private void getApiCall(){
        Call<ArrayList<Pojo_Amendment>> call = ApiClient.getTryCatchInterface().getamendmentData();
        call.enqueue(new Callback<ArrayList<Pojo_Amendment>>() {


            @Override
            public void onResponse(Call<ArrayList<Pojo_Amendment>> call, Response<ArrayList<Pojo_Amendment>> response) {
                if(response.code()==200 && response.body()!=null){
                    recyclerAdapter  = new Amendment_Adapter(Amendment_Activity.this,response.body());
                    rv.setLayoutManager(new LinearLayoutManager(Amendment_Activity.this));

                    loaer.setVisibility(View.GONE);
                    rv.setVisibility(View.VISIBLE);

                    rv.setAdapter(recyclerAdapter);

                }else if(response.code()==401){
                    Toast.makeText(Amendment_Activity.this, "Unauthorized",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Amendment_Activity.this, "Error",Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<ArrayList<Pojo_Amendment>> call, Throwable t) {
                Toast.makeText(Amendment_Activity.this, "Something went Wrong",Toast.LENGTH_SHORT).show();
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