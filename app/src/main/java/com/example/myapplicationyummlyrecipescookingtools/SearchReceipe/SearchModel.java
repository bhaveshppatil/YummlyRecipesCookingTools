package com.example.myapplicationyummlyrecipescookingtools.SearchReceipe;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SearchModel implements Serializable {

    @SerializedName("videoUrl")
    private String videoUrl;

    @SerializedName("receipe")
    private String receipe;

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getReceipe() {
        return receipe;
    }
}