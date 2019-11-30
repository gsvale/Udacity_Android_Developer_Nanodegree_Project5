package com.example.getjokes;

public class JokeWizard {

    private static final String JOKE_EXAMPLE = "I ate a clock yesterday, it was very time-consuming.";

    private String mJoke;

    public JokeWizard(){
        this.mJoke = JOKE_EXAMPLE;
    }

    // Method that returns the joke
    public String getJoke(){
        return mJoke;
    }

}
