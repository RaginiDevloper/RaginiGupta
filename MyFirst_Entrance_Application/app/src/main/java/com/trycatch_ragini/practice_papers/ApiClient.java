package com.trycatch_ragini.practice_papers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApiClient {


    public static TryCatchInterface tryCatchInterface;
    public static TryCatchInterface getTryCatchInterface() {
        if (tryCatchInterface == null) {
            OkHttpClient client = new OkHttpClient.Builder().connectTimeout(80, TimeUnit.SECONDS).connectTimeout(80, TimeUnit.SECONDS)
                    .build();
            Gson gson = new GsonBuilder().setLenient().create();
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://mapi.trycatchtech.com").addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson)).client(client)
                    .build();
            tryCatchInterface = retrofit.create(TryCatchInterface.class);
        }
        return tryCatchInterface;

    }

   public  interface TryCatchInterface{

        @GET("v3/twelfth_question_papers/year_list?category=mains")
        Call<ArrayList<Pojo>> getData(@Query("category_id") int category_id, @Query("year")int Year);

       @GET("v3/twelfth_question_papers/year_list?category=neet")
       Call<ArrayList<NEET_Pojo>> newgetData(@Query("category_id") int category_id, @Query("year")int Year);


   }



        }







