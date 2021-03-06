package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationyummlyrecipescookingtools.Activities.Thermometer
import com.example.myapplicationyummlyrecipescookingtools.Activities.VegetarianActivity
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ArticlesAdapter
import com.example.myapplicationyummlyrecipescookingtools.Adapter.CLickListener
import com.example.myapplicationyummlyrecipescookingtools.Models.Article
import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.InputStream

class ProfileFragment : Fragment(R.layout.fragment_profile), CLickListener {

    private var articlesModelList = mutableListOf<ArticlesModel>()
    private lateinit var articlesAdapter: ArticlesAdapter
    private lateinit var mAuth: FirebaseAuth

    private val runnable = Runnable {
        readJson()
    }

    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = mAuth.currentUser
        tvUsername.text = user!!.displayName
        Glide.with(profilePic).load(user.photoUrl).into(profilePic)
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

        mAuth = FirebaseAuth.getInstance()

        val recyclerView = view.findViewById<RecyclerView>(R.id.ProfileRecyclerView)
        articlesAdapter = context?.let { ArticlesAdapter(it, articlesModelList, this) }!!
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = articlesAdapter
        startBackground()

        val thermometer = view.findViewById<ImageView>(R.id.imgThermometer)
        thermometer.setOnClickListener {
            val intent = Intent(context, Thermometer::class.java)
            startActivity(intent)
        }
    }

    override fun onReceipeClick(receipeModel: ReceipeModel) {

    }

    override fun onArticleClick(articlesModel: ArticlesModel) {
        val intent = Intent(context, VegetarianActivity::class.java)
        startActivity(intent)
    }
}