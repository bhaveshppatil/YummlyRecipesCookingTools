package com.example.myapplicationyummlyrecipescookingtools.Adapter

import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ProUsersModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Models.SearchModel

interface CLickListener {
    fun onReceipeClick(receipeModel: ReceipeModel)
    fun onArticleClick(articlesModel: ArticlesModel)


}
interface listner{
    fun onViewMoreItemClick(receipeModel: ReceipeModel)
}

interface ViewMoreItemClick{
    fun onItemClick(receipeModel: ReceipeModel)
}

interface UserListener{
    fun onUserClick(proUsersModel: ProUsersModel)
}
interface SearchListener{
    fun onSearchItemClick(searchModel: SearchModel)
}