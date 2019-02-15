package com.githubd.dixitjain.githubapp.networks;

import com.githubd.dixitjain.githubapp.model.Results;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


// API builder Class
public class ApiBuilder {

    private static final String BASE_URL = "https://api.github.com/search/";


    private ApiBuilder() {}

    public static Observable<Results> getApiBuilder(String search) {

        return new Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()
    .create(IGitData.class)
    .getRepo(search);
    }
}