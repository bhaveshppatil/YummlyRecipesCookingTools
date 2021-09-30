package com.example.myapplicationyummlyrecipescookingtools.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ReceipeModel implements Serializable {

	@SerializedName("Images")
	private String images;

	@SerializedName("RecipeName")
	private String recipeName;

	@SerializedName("User")
	private String user;

	@SerializedName("Ingredients")
	private String ingredients;

	@SerializedName("Minutes")
	private String minutes;

	@SerializedName("Calories")
	private String calories;

	@SerializedName("Collection")
	private String collection;

	public String getImages(){
		return images;
	}

	public String getRecipeName(){
		return recipeName;
	}

	public String getUser(){
		return user;
	}

	public String getIngredients(){
		return ingredients;
	}

	public String getMinutes(){
		return minutes;
	}

	public String getCalories(){
		return calories;
	}

	public String getCollection(){
		return collection;
	}

	@Override
 	public String toString(){
		return 
			"ReceipeModel{" + 
			"images = '" + images + '\'' + 
			",recipeName = '" + recipeName + '\'' + 
			",user = '" + user + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",minutes = '" + minutes + '\'' + 
			",calories = '" + calories + '\'' + 
			",collection = '" + collection + '\'' + 
			"}";
		}
}