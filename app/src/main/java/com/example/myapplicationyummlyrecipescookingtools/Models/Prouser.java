package com.example.myapplicationyummlyrecipescookingtools.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Prouser implements Serializable {

	@SerializedName("ProUsers")
	private List<ProUsersModel> proUsers;

	public List<ProUsersModel> getProUsers(){
		return proUsers;
	}
}