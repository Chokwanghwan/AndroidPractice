package com.example.chokwanghwan.myapplication;

/**
 * Created by chokwanghwan on 15. 8. 13..
 */
public class Word {
    private String english;
    private String mean;

    Word(String english, String mean) {
        this.english = english;
        this.mean = mean;
    }

    public String getEnglish() {
        return english;
    }

    public String getMean() {
        return mean;
    }
}