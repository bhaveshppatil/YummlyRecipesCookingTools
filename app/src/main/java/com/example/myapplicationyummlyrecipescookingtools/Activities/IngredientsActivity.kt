package com.example.myapplicationyummlyrecipescookingtools.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplicationyummlyrecipescookingtools.R
import com.example.myapplicationyummlyrecipescookingtools.RelatedActivity
import kotlinx.android.synthetic.main.activity_ingredients.*
import kotlinx.android.synthetic.main.one_extra_layout.*

class IngredientsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        supportActionBar?.hide()


        val intent = intent
        val image = intent.getStringExtra("image")
        val minutes = intent.getStringExtra("minutes")
        val ingredient = intent.getStringExtra("ingredient")
        val calories = intent.getStringExtra("calories")

        txtIngredients.text = "$ingredient Ingredients"
        txtCalories.text = "$calories calories"
        tvMinutes.text = "$minutes minutes"

        Glide.with(imageRecipe).load(image).into(imageRecipe)

        viewMoreRelated.setOnClickListener {
            val intent = Intent(this, RelatedActivity::class.java)
            startActivity(intent)
        }
        viewMorePipEbby.setOnClickListener {
            val intent = Intent(this, PipEbbyViewMore::class.java)

            startActivity(intent)
        }
        circleCalories.setOnClickListener {
            val intent=Intent(this, PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        circleSodium.setOnClickListener {
            val intent=Intent(this, PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        circleCarbs.setOnClickListener {
            val intent=Intent(this, PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        circleFiber.setOnClickListener {
            val intent=Intent(this, PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        circlePotassium.setOnClickListener {
            val intent=Intent(this, PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        circleViewMore.setOnClickListener {
            val intent=Intent(this, PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        circleFat.setOnClickListener {
            val intent=Intent(this, PrimeMemberActivity::class.java)
            startActivity(intent)
        }


    }
}