package com.example.myapplicationyummlyrecipescookingtools.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationyummlyrecipescookingtools.R
import com.example.myapplicationyummlyrecipescookingtools.Receipe
import com.example.myapplicationyummlyrecipescookingtools.RelatedAdapter
import com.example.myapplicationyummlyrecipescookingtools.Models.ResponseModel
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ViewMoreItemClick
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Activities.IngredientsActivity
import com.example.myapplicationyummlyrecipescookingtools.RelatedResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.pipe_ebby_layout.*
import java.io.InputStream

class PipEbbyViewMore: AppCompatActivity(), ViewMoreItemClick {

    private var receipeModelList = mutableListOf<ReceipeModel>()
    private lateinit var recipeAdapter: RelatedAdapter

    private val runnable = Runnable {
        readJsonFile()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pipe_ebby_layout)

        supportActionBar?.hide()

        recipeAdapter= RelatedAdapter(this,receipeModelList, this)
        recyclerViewPipe.layoutManager= LinearLayoutManager(this)
        recyclerViewPipe.adapter=recipeAdapter
        startBackground()
    }

    private fun startBackground() {
        val thread = Thread(runnable)
        thread.start()
    }

    private fun readJsonFile() {
        try {
            var inputStream: InputStream = this.assets.open("receipe.json")
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

    private fun buildPojoFromJson(json: String) {
        val type = object : TypeToken<ResponseModel?>() {}.type
        val responseModel: ResponseModel = Gson().fromJson(json, type)
        receipeModelList = responseModel.receipe as MutableList<ReceipeModel>
        updateUi()
    }


    private fun updateUi() {
        runOnUiThread {
            recipeAdapter.updateData(receipeModelList)
        }
    }
    override fun onItemClick(receipeModel: ReceipeModel) {

        val intent = Intent(this, IngredientsActivity::class.java)
        intent.putExtra("image", receipeModel.images)
        intent.putExtra("ingredient", receipeModel.ingredients)
        intent.putExtra("calories", receipeModel.calories)
        intent.putExtra("minutes", receipeModel.minutes)
        startActivity(intent)
    }
}