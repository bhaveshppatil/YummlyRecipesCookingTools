package com.example.myapplicationyummlyrecipescookingtools.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Vegetarian implements Serializable {

    @SerializedName("Vegetarian")
    private List<VegetarianModel> vegetarian;

    public List<VegetarianModel> getVegetarian() {
        return vegetarian;
    }
}