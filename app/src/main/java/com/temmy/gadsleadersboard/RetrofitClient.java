package com.temmy.gadsleadersboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient myClient;
    private static final  String BASE_URL = "https://docs.google.com/forms/d/e/";
    private Retrofit mRetrofit;

    private RetrofitClient(){
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static synchronized RetrofitClient getInstance(){
        if(myClient == null){
            myClient = new RetrofitClient();
        }
        return myClient;
    }
    public  APIsInterface getApi(){
        return mRetrofit.create(APIsInterface.class);
    }



}
