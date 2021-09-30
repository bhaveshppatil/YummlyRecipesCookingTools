package com.example.myapplicationyummlyrecipescookingtools.beforeHomepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationyummlyrecipescookingtools.R
import java.util.*

class SplashScreen : AppCompatActivity() {

    lateinit var timer:Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashScreen, SignupActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 4000)

    }
}