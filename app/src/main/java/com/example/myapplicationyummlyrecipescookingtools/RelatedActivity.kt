package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplicationyummlyrecipescookingtools.Activities.IngredientsActivity
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ViewMoreItemClick
import com.example.myapplicationyummlyrecipescookingtools.Models.ResponseModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_related.*
import java.io.InputStream

class RelatedActivity : AppCompatActivity(), ViewMoreItemClick {

    private var receipeModelList = mutableListOf<ReceipeModel>()
    private lateinit var relatedAdapter: RelatedAdapter

    private val runnable = Runnable {
        readJsonFile()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_related)

        relatedAdapter = RelatedAdapter(this, receipeModelList, this)
        recyclerViewInViewMoreRelated.layoutManager = LinearLayoutManager(this)
        recyclerViewInViewMoreRelated.adapter = relatedAdapter
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
            relatedAdapter.updateData(receipeModelList)
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