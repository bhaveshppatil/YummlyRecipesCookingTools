package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.Activities.VegetarianActivity
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ArticlesAdapter
import com.example.myapplicationyummlyrecipescookingtools.Adapter.CLickListener
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ReceipeAdapter
import com.example.myapplicationyummlyrecipescookingtools.Models.Article
import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ResponseModel
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream


class ExploreFragment : Fragment(R.layout.fragment_explore), CLickListener {
    private var articlesModelList = mutableListOf<ArticlesModel>()
    private lateinit var articlesAdapter: ArticlesAdapter

    private val runnable = Runnable {
        readJson()
    }
    private fun readJson() {
        try {
            var inputStream: InputStream = context?.assets?.open("articles.json")!!
            var data = inputStream.read()
            var builder: StringBuilder = StringBuilder()
            while (data != -1) {
                val ch = data.toChar()
                builder.append(ch)
                data = inputStream.read()
            }
            buildPojoFromJson(builder.toString())

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun startBackground() {
        val thread = Thread(runnable)
        thread.start()
    }

    private fun buildPojoFromJson(json: String) {
        val type = object : TypeToken<Article?>() {}.type
        val articlesModel: Article = Gson().fromJson(json, type)
        articlesModelList = articlesModel.articles as MutableList<ArticlesModel>
        updateUi()
    }

    private fun updateUi() {
        activity?.runOnUiThread {
            articlesAdapter.updateData(articlesModelList)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_articles)
        articlesAdapter = context?.let { ArticlesAdapter(it, articlesModelList, this) }!!
        val gridLayoutManager = GridLayoutManager(context,2)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = articlesAdapter
        startBackground()
    }

    override fun onReceipeClick(receipeModel: ReceipeModel) {
        val intent = Intent(context, VegetarianActivity::class.java)
        startActivity(intent)
    }

    override fun onArticleClick(articlesModel: ArticlesModel) {
        val intent = Intent(context, VegetarianActivity::class.java)
        startActivity(intent)
    }
}