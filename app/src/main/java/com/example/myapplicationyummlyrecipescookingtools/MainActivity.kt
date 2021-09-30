package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.one_extra_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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