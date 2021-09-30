package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationyummlyrecipescookingtools.Activities.YummlyWelcome
import com.example.myapplicationyummlyrecipescookingtools.beforeHomepage.SignupActivity
import kotlinx.android.synthetic.main.one_extra_layout.*
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.hide()

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@MainActivity, YummlyWelcome::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)

    }
}