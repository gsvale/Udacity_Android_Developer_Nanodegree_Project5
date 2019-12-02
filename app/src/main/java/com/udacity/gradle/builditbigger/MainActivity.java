package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.displayjoke.DisplayJokeActivity;


public class MainActivity extends AppCompatActivity implements GetTaskResultCallback {

    private ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ProgressBar to show loading of joke
        loadingProgressBar = findViewById(R.id.loading_pb);
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

    // Method called when button is clicked
    public void tellJoke(View view) {

        // Call AsyncTask to retrieve jokes from module
        new MyApiAsyncTask(this).execute();
        loadingProgressBar.setVisibility(View.VISIBLE);

    }

    // Function that gets the result from jokes task
    @Override
    public void onGetTaskResult(String result) {
        // Display the joke in an activity from Android Library
        if (!TextUtils.isEmpty(result)) {
            Intent intent = new Intent(this, DisplayJokeActivity.class);
            intent.putExtra(DisplayJokeActivity.JOKE_KEY_TAG, result);
            startActivity(intent);
        }
        loadingProgressBar.setVisibility(View.GONE);
    }

}
