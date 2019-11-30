package com.example.displayjoke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static String JOKE_KEY_TAG = "JOKE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        // Display joke received from intent bundle
        Intent intent = getIntent();
        if(intent != null) {
            String joke = intent.getStringExtra(JOKE_KEY_TAG);
            TextView jokeTv = findViewById(R.id.joke_tv);
            jokeTv.setText(joke);
        }

    }
}
