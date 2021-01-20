package com.app.itzpkyadav.bottomsheetdialog;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Itzpkyadav (itzpkyadav@gmail.com) on 20-01-2021
 * Copyright (c) 2021 itzpkyadav@gmail.com
 */
public class MyRetrofit {
    private static final String BASE_URL = "https://uniqueandrocode.000webhostapp.com/hiren/androidtutorial/mycart/";
    private static final String ANOTHER_BASE_URL = "https://reqres.in";
    private static MyRetrofit myRetrofit;
    private Retrofit retrofit;

    private MyRetrofit() {

//        retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofit = new Retrofit.Builder().baseUrl(ANOTHER_BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static synchronized MyRetrofit getInstance() {
        if (myRetrofit == null) {
            myRetrofit = new MyRetrofit();
        }
        return myRetrofit;
    }

    public ProductApi productApi() {
        return retrofit.create(ProductApi.class);
    }

}