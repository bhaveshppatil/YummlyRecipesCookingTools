package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.Activities.IngredientsActivity
import com.example.myapplicationyummlyrecipescookingtools.Adapter.CLickListener
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ReceipeAdapter
import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ResponseModel
import com.example.myapplicationyummlyrecipescookingtools.PipEbbyViewMore
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream


class JustForYouFragment : Fragment(R.layout.fragment_just_for_you), CLickListener {

    private var recipeList = mutableListOf<ReceipeModel>()
    private lateinit var recipeAdapter: ReceipeAdapter

    private val runnable = Runnable {
        readJson()
    }

    private fun readJson() {
        try {
            var inputStream: InputStream = context?.assets?.open("receipe.json")!!
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
        val type = object : TypeToken<ResponseModel?>() {}.type
        val responseModel: ResponseModel = Gson().fromJson(json, type)
        recipeList = responseModel.receipe as MutableList<ReceipeModel>
        updateUi()
    }

    private fun updateUi() {
        activity?.runOnUiThread {
            recipeAdapter.updateData(recipeList)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_for_you)
        recipeAdapter = context?.let { ReceipeAdapter(it, recipeList, this) }!!
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recipeAdapter
        startBackground()
    }

    override fun onReceipeClick(receipeModel: ReceipeModel) {
        val  intent = Intent(context, IngredientsActivity::class.java)
        intent.putExtra("image", receipeModel.images)
        intent.putExtra("ingredient", receipeModel.ingredients)
        intent.putExtra("calories", receipeModel.calories)
        intent.putExtra("minutes", receipeModel.minutes)

        startActivity(intent)
    }

    override fun onArticleClick(articlesModel: ArticlesModel) {
    }
}