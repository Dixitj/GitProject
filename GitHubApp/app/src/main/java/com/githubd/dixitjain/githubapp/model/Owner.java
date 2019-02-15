package com.githubd.dixitjain.githubapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;

    public Integer getId() {
        return id;
    }


    public String getAvatarUrl() {
        return avatarUrl;
    }


}