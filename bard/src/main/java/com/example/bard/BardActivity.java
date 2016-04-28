package com.example.bard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class BardActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "EXTRA_JOKE";

    public static Intent getBardActivityIntent(Context context, String joke) {
        Intent intent = new Intent(context, BardActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);

        return intent;
    }

    private TextView mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bard);

        mJoke = (TextView) findViewById(R.id.bard_joke);

        String joke = getIntent().getStringExtra(EXTRA_JOKE);

        mJoke.setText(joke);
    }
}
