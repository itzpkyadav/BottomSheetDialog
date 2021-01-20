package com.app.itzpkyadav.bottomsheetdialog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Itzpkyadav (itzpkyadav@gmail.com) on 20-01-2021
 * Copyright (c) 2021 itzpkyadav@gmail.com
 */
public class ProductList {

    @SerializedName("id")
    public int id;

    @SerializedName("prname")
    public String prname;

    @SerializedName("primage")
    public String primage;

    @SerializedName("prprice")
    public String prprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public String getPrimage() {
        return primage;
    }

    public void setPrimage(String primage) {
        this.primage = primage;
    }

    public String getPrprice() {
        return prprice;
    }

    public void setPrprice(String prprice) {
        this.prprice = prprice;
    }
}