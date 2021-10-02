package com.example.myapplicationyummlyrecipescookingtools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_related.*
import java.io.InputStream

class PipEbbyViewMore: AppCompatActivity() {
    private var recipeList= mutableListOf<Receipe>()
    private lateinit var recipeAdapter:RelatedAdapter

    private val runnable = Runnable {
        readJsonFile()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_related)

        recipeAdapter= RelatedAdapter(this,recipeList)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=recipeAdapter
        startBackground()
    }

    private fun startBackground() {
        val thread = Thread(runnable)
        thread.start()
    }

    private fun readJsonFile() {
        try {
            var inputStream: InputStream =this.assets.open("recipeDetails.json")
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

    private fun buildPojoFromJson(json:String) {
        val type = object : TypeToken<RelatedResponse?>() {}.type
        val responseModel: RelatedResponse = Gson().fromJson(json, type)
        recipeList= responseModel.Receipe as MutableList<Receipe>
        updateUi()
    }

    private fun updateUi() {
        runOnUiThread {
            recipeAdapter.updateData(recipeList)
        }
    }


}