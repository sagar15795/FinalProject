package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.jokeview.JokeActivity;
import com.udacity.gradle.builditbigger.data.model.JokeReply;
import com.udacity.gradle.builditbigger.data.remote.BaseAPIManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new BaseAPIManager().getJokeApi().getJoke().enqueue(new Callback<JokeReply>() {
            @Override
            public void onResponse(Call<JokeReply> call, Response<JokeReply> response) {
                Log.e("TAG", "onResponse:"+ response.body().getData());
                Intent intent =new Intent(MainActivity.this, JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_INTENT,response.body().getData());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<JokeReply> call, Throwable t) {
                Log.e("TAG", "onResponse:"+ t.getLocalizedMessage());
            }
        });

        //Toast.makeText(this, new MyJokes().getMeJoke(), Toast.LENGTH_SHORT).show();
    }



}
