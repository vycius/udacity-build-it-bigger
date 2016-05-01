package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends BaseMainActivity {

    public static final String STATE_AD_SHOWED = "ad_showed";

    private InterstitialAd mInterstitialAd;
    private boolean adShowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null) {
            adShowed = savedInstanceState.getBoolean(STATE_AD_SHOWED, false);
        }

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        requestNewInterstitial();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(STATE_AD_SHOWED, adShowed);

        super.onSaveInstanceState(outState);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                loadJoke();
            }
        });
    }

    @Override
    public void tellJoke(View view) {
        if (mInterstitialAd.isLoaded() && !adShowed) {
            adShowed = true;
            mInterstitialAd.show();
        } else {
            super.tellJoke(view);
        }
    }
}
