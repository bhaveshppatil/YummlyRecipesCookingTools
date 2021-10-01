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
        subscription.setOnClickListener {
            val intent=Intent(this,PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        preferences.setOnClickListener {
            val intent=Intent(this,PreferencesActivity::class.java)
            startActivity(intent)
        }
        aboutYummly.setOnClickListener {
            val intent=Intent(this,AboutYummlyActivity::class.java)
            startActivity(intent)
        }
        feedback.setOnClickListener {
            val intent=Intent(this,FeedbackActivity::class.java)
            startActivity(intent)
        }

    }
}