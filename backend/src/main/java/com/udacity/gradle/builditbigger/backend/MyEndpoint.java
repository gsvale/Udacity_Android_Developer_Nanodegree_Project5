package com.udacity.gradle.builditbigger.backend;

import com.example.getjokes.JokeWizard;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;


/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    // Method that returns the jokes, in this case the joke example from the java library
    @ApiMethod(name = "getJokes")
    public MyJoke getJokes() {
        MyJoke myJoke = new MyJoke();
        myJoke.setJoke(new JokeWizard().getJoke());
        return myJoke;
    }

}