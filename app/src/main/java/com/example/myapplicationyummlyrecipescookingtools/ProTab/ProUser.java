package com.example.myapplicationyummlyrecipescookingtools.ProTab;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProUser implements Serializable {

	@SerializedName("ProUsers")
	private List<ProUsersModel> proUsers;

	public List<ProUsersModel> getProUsers(){
		return proUsers;
	}
}