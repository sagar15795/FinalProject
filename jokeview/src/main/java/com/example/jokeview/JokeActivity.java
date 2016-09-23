package com.example.jokeview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE_INTENT = "joke_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        TextView tvJoke = (TextView) findViewById(R.id.joke);
        tvJoke.setText(intent.getStringExtra(JOKE_INTENT));

    }
}
