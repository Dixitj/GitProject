package com.githubd.dixitjain.githubapp.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("items")
    @Expose
    private List<Item> items = null;



    public List<Item> getItems() {
        return items;
    }


}