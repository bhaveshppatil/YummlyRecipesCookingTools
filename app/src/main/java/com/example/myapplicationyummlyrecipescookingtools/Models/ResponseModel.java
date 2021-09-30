package com.example.myapplicationyummlyrecipescookingtools.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("Receipe")
	private List<ReceipeModel> receipe;

	public List<ReceipeModel> getReceipe(){
		return receipe;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"receipe = '" + receipe + '\'' + 
			"}";
		}
}