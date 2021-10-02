package com.example.myapplicationyummlyrecipescookingtools.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SearchDataModel implements Serializable {

    @SerializedName("Search")
    private List<SearchModel> search;

    public List<SearchModel> getSearch() {
        return search;
    }
}