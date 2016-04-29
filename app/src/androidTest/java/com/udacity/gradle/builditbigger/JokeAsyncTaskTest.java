package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class JokeAsyncTaskTest extends AndroidTestCase {

    public void test() throws InterruptedException, ExecutionException, TimeoutException {
        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(new JokeListener() {
            @Override
            public void onJokeLoaded(String joke) {
            }
        });

        jokeAsyncTask.execute();

        String joke = jokeAsyncTask.get(20, TimeUnit.SECONDS);

        assertNotNull(joke);
    }

}
