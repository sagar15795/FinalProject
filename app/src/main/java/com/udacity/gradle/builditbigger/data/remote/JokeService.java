package com.udacity.gradle.builditbigger.data.remote;

import com.udacity.gradle.builditbigger.data.model.JokeReply;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by lusifer on 23/09/16.
 */
public interface JokeService {

    @POST("sayHi/ddf")
    Call<JokeReply> getJoke();
}
