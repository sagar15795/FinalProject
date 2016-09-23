package com.udacity.gradle.builditbigger.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lusifer on 23/09/16.
 */
public class BaseAPIManager {

    public static final String END_POINT = "https://udacity-144306.appspot.com/_ah/api/myApi/v1/";
    public JokeService mJokeService;

    public BaseAPIManager() {

        mJokeService = createApi(JokeService.class, END_POINT);
    }

    /******** Helper class that sets up a new services *******/

    private <T> T createApi(Class<T> clazz, String ENDPOINT) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }

    public JokeService getJokeApi() {
        return mJokeService;
    }
}
