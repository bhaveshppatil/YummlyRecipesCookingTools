package com.example.myapplicationyummlyrecipescookingtools.Adapter

import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ProUsersModel

interface CLickListener {
    fun onReceipeClick(receipeModel: ReceipeModel)
    fun onArticleClick(articlesModel: ArticlesModel)

}

interface userListener{
    fun onUserClick(proUsersModel: ProUsersModel)
}