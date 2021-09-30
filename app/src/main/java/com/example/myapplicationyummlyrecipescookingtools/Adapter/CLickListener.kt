package com.example.myapplicationyummlyrecipescookingtools.Adapter

import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel

interface CLickListener {
    fun onReceipeClick(receipeModel: ReceipeModel)
    fun onArticleClick(articlesModel: ArticlesModel)

}