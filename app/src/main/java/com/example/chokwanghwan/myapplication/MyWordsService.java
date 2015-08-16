package com.example.chokwanghwan.myapplication;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by chokwanghwan on 15. 8. 15..
 */
public interface MyWordsService {
    @GET("/allWords")
    void listWords(Callback<List<Word>> callback);
}
