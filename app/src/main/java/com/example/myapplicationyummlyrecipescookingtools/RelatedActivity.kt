package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationyummlyrecipescookingtools.Activities.IngredientsActivity
import com.example.myapplicationyummlyrecipescookingtools.Adapter.CLickListener
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ViewMoreItemClick
import com.example.myapplicationyummlyrecipescookingtools.Adapter.listner
import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ResponseModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_pipe_ebby_view_more.*
import kotlinx.android.synthetic.main.activity_related.*
import java.io.InputStream

class RelatedActivity : AppCompatActivity(), listner{

    private var recipeList= mutableListOf<ReceipeModel>()
    private lateinit var recipeAdapter: RelatedAdapter

    private val runnable = Runnable {
        readJsonFile()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_related)

        recipeAdapter= RelatedAdapter(this,recipeList,this)
        recyclerViewInViewMoreRelated.layoutManager= LinearLayoutManager(this)
        recyclerViewInViewMoreRelated.adapter=recipeAdapter
        startBackground()
    }

    private fun startBackground() {
        val thread = Thread(runnable)
        thread.start()
    }

    private fun readJsonFile() {
        try {
            var inputStream: InputStream =this.assets.open("receipe.json")
            var data=inputStream.read()
            var builder:StringBuilder= StringBuilder()
            while(data!=-1){
                val ch = data.toChar()
                builder.append(ch)
                data = inputStream.read()
            }
            buildPojoFromJson(builder.toString())

        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun buildPojoFromJson(json: String) {
        val type = object : TypeToken<ResponseModel?>() {}.type
        val responseModel: ResponseModel = Gson().fromJson(json, type)
        recipeList = responseModel.receipe as MutableList<ReceipeModel>
        updateUi()
    }

    private fun updateUi() {
        runOnUiThread {
            recipeAdapter.updateData(recipeList)
        }
    }

    override fun onViewMoreItemClick(receipeModel: ReceipeModel) {
        val intent = Intent(this, IngredientsActivity::class.java)
        intent.putExtra("image", receipeModel.images)
        intent.putExtra("ingredient", receipeModel.ingredients)
        intent.putExtra("calories", receipeModel.calories)
        intent.putExtra("minutes", receipeModel.minutes)
        startActivity(intent)
    }


}