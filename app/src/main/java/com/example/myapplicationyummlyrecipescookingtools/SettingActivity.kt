package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        myAccount.setOnClickListener {
            val intent=Intent(this,MyAccountActivity::class.java)
            startActivity(intent)
        }
    }
}