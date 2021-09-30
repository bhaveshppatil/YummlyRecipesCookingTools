package com.example.myapplicationyummlyrecipescookingtools.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class VegetarianModel implements Serializable {

	@SerializedName("Images")
	private String images;

	@SerializedName("ArticleName")
	private String articleName;

	@SerializedName("Tag")
	private String tag;

	@SerializedName("link")
	private String link;

	public String getImages(){
		return images;
	}

	public String getArticleName(){
		return articleName;
	}

	public String getTag(){
		return tag;
	}

	public String getLink(){
		return link;
	}
}