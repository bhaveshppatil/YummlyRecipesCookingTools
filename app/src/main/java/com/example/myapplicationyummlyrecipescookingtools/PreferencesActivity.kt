package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationyummlyrecipescookingtools.Fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.activity_preferences.*

class PreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)
        arrowImageInPreference.setOnClickListener {
            val intent= Intent(this,SettingsFragment::class.java)
            startActivity(intent)
        }
    }
}