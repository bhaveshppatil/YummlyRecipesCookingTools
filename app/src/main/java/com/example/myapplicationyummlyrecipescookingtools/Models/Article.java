package com.example.myapplicationyummlyrecipescookingtools.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Article implements Serializable {

	@SerializedName("Articles")
	private List<ArticlesModel> articles;

	public List<ArticlesModel> getArticles(){
		return articles;
	}
}