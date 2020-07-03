package com.suek.practice05;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {

    public static Retrofit getInstance(){

        Retrofit.Builder builder= new Retrofit.Builder();
        builder.baseUrl("https://www.googleapis.com");   //https://www.googleapis.com/youtube/v3/search
        builder.addConverterFactory(ScalarsConverterFactory.create());
        return builder.build();

    }
}
