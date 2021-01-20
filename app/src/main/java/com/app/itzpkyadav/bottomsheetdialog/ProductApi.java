package com.app.itzpkyadav.bottomsheetdialog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Itzpkyadav (itzpkyadav@gmail.com) on 20-01-2021
 * Copyright (c) 2021 itzpkyadav@gmail.com
 */
public interface ProductApi {


    @GET("getdata.php")
    Call<List<ProductList>> getProductData();

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);
}