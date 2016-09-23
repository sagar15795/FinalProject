package com.udacity.gradle.builditbigger;

import android.util.Log;

import com.udacity.gradle.builditbigger.data.model.JokeReply;
import com.udacity.gradle.builditbigger.data.remote.BaseAPIManager;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lusifer on 23/09/16.
 */
public class JokeTest {

    @Test
    public void jokeValidator(){
        new BaseAPIManager().getJokeApi().getJoke().enqueue(new Callback<JokeReply>() {
            @Override
            public void onResponse(Call<JokeReply> call, Response<JokeReply> response) {
                Log.e("TAG", "onResponse:"+ response.body().getData());
                Assert.assertFalse( response.body().getData().length() != 0);
            }

            @Override
            public void onFailure(Call<JokeReply> call, Throwable t) {
                Log.e("TAG", "onResponse:"+ t.getLocalizedMessage());
                Assert.fail();
            }
        });
    }
}
