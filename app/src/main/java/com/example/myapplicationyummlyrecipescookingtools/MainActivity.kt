package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationyummlyrecipescookingtools.Activities.HomeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.one_extra_layout.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button: Button = findViewById(R.id.btnDemo)

        button.setOnClickListener {
            val intent = Intent(this, HomeScreen::class.java)

        viewMoreRelated.setOnClickListener {
         val intent= Intent(this,RelatedActivity::class.java)
            startActivity(intent)
        }
        viewMorePipEbby.setOnClickListener {
            val intent= Intent(this,RelatedActivity::class.java)

            startActivity(intent)
        }

    }
}