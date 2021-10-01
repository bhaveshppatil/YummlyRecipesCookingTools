package com.example.myapplicationyummlyrecipescookingtools.Models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProUsersModel implements Serializable {

	@SerializedName("image")
	private String image;

	@SerializedName("userProfile")
	private String userProfile;

	@SerializedName("caption")
	private String caption;

	@SerializedName("username")
	private String username;

	public String getImage(){
		return image;
	}

	public String getUserProfile(){
		return userProfile;
	}

	public String getCaption(){
		return caption;
	}

	public String getUsername(){
		return username;
	}
}