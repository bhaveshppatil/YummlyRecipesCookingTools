package com.example.myapplicationyummlyrecipescookingtools.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ArticlesModel implements Serializable {

    @SerializedName("Images")
    private String images;

    @SerializedName("ArticleName")
    private String articleName;

    @SerializedName("icon")
    private String icon;

    @SerializedName("count")
    private String count;

    public String getImages() {
        return images;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getIcon() {
        return icon;
    }

    public String getCount() {
        return count;
    }
}