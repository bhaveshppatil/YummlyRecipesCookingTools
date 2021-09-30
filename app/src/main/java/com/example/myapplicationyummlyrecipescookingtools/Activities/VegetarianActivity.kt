package com.example.myapplicationyummlyrecipescookingtools.Activities

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ArticleContentAdapter
import com.example.myapplicationyummlyrecipescookingtools.Adapter.VegetarianListener
import com.example.myapplicationyummlyrecipescookingtools.Models.Vegetarian
import com.example.myapplicationyummlyrecipescookingtools.Models.VegetarianModel
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_vegetarian.*
import java.io.InputStream

class VegetarianActivity : AppCompatActivity(), VegetarianListener {

    private var vegetarianModelList = mutableListOf<VegetarianModel>()
    private lateinit var articleContentAdapter: ArticleContentAdapter

    private val runnable = Runnable {
        readJson()
    }

    private fun readJson() {
        try {
            var inputStream: InputStream = assets?.open("vegetarian.json")!!
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
        val type = object : TypeToken<Vegetarian?>() {}.type
        val vegetarianModel: Vegetarian = Gson().fromJson(json, type)
        vegetarianModelList = vegetarianModel.vegetarian as MutableList<VegetarianModel>
        updateUi()
    }

    private fun updateUi() {
        runOnUiThread {
            articleContentAdapter.updateData(vegetarianModelList)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegetarian)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_articles_content)
        articleContentAdapter = ArticleContentAdapter(this, vegetarianModelList, this)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = articleContentAdapter
        startBackground()
    }

    override fun onContentClick(vegetarianModel: VegetarianModel) {

        val webView = findViewById<WebView>(R.id.webView)
        webView.visibility = View.VISIBLE

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.loadUrl(vegetarianModel.link)
        webView.settings.setSupportZoom(true)
        WebView.setWebContentsDebuggingEnabled(false)

    }

    override fun onBackPressed() {
        if (webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }
}