package com;

import com.example.Pojo_Parts;
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
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://mapi.trycatchtech.com").addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson)).client(client)
                    .build();
            tryCatchInterface = retrofit.create(TryCatchInterface.class);
        }
        return tryCatchInterface;

    }

   public  interface TryCatchInterface{

        @GET("v3/constitution_of_india/constitution_of_india_preamble")
        Call<ArrayList<Pojo_Preamble>> getData() ;

       @GET("v3/constitution_of_india/constitution_of_india_schedule")
       Call<ArrayList<Pojo_Schedule>> getscheduleData() ;

       @GET("v3/constitution_of_india/constitution_of_india_amendments")
       Call<ArrayList<Pojo_Amendment>> getamendmentData() ;

       @GET("/v3/constitution_of_india/constitution_of_india_news_article")
       Call<ArrayList<Pojo_NewsArticles>> getnewsData() ;

       @GET("v3/constitution_of_india/constitution_of_india_parts")
       Call<ArrayList<Pojo_Parts>> getpartData() ;

       @GET("v3/constitution_of_india/constitution_of_india_articles")
       Call<ArrayList<Pojo_Article>> getarticleData(@Query("part_id") int id) ;

       @GET("v3/constitution_of_india/constitution_of_india_case_study")
       Call<ArrayList<Pojo_CaseStudy>> getcasestudiessData() ;


   }


        }







