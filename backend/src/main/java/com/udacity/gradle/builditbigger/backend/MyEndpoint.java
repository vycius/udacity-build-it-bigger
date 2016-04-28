/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.Random;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
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

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "joke", path = "joke")
    public MyBean sayJoke() {
        String[] jokes = new String[]{
                "A SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\"",
                "When your hammer is C++, everything begins to look like a thumb.",
                "Programming is like sex:\n" +
                        "One mistake and you have to support it for the rest of your life."
        };

        int selectedJokeIndex = new Random().nextInt(jokes.length);

        String selectedJoke = jokes[selectedJokeIndex];

        MyBean response = new MyBean();
        response.setData(selectedJoke);

        return response;
    }

}
