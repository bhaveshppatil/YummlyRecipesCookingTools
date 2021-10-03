package com.example.myapplicationyummlyrecipescookingtools.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationyummlyrecipescookingtools.Fragments.SettingsFragment
import com.example.myapplicationyummlyrecipescookingtools.R
import kotlinx.android.synthetic.main.activity_preferences.*

class PreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        supportActionBar?.hide()

        arrowImageInPreference.setOnClickListener {
            val intent= Intent(this,SettingsFragment::class.java)
            startActivity(intent)
        }
    }
}