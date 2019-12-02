package com.udacity.gradle.builditbigger.backend;

/** The object model for the joke data we are sending through endpoints */
public class MyJoke {

    private String mJoke;

    public String getJoke() {
        return mJoke;
    }

    public void setJoke(String joke) {
        mJoke = joke;
    }
}