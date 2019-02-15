package com.githubd.dixitjain.githubapp.networks;

import com.githubd.dixitjain.githubapp.model.Results;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IGitData {

    //GET statement
    @GET("repositories?+language:assembly&sort=stars&order=desc")
    Observable<Results> getRepo(@Query("q") String search);


}
