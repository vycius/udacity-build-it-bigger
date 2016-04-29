package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;

import com.example.JokeTeller;
import com.example.bard.BardActivity;

import java.io.IOException;


class JokeAsyncTask extends AsyncTask<Void, Void, String> {

    JokeListener jokeListener;

    public JokeAsyncTask(JokeListener listener) {
        jokeListener = listener;
    }


    @Override
    protected String doInBackground(Void... params) {
        try {
            return JokeTeller.getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(jokeListener != null) {
            jokeListener.onJokeLoaded(result);
        }
    }
}
