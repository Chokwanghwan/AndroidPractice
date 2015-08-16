package com.example.chokwanghwan.myapplication;

import android.app.Application;

import retrofit.RestAdapter;

/**
 * Created by chokwanghwan on 15. 8. 15..
 */
public class MWApplication extends Application {
    MyWordsService myWordsService;
    @Override
    public void onCreate() {
        super.onCreate();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://54.92.37.26")
                .build();
        myWordsService = restAdapter.create(MyWordsService.class);
    }
}