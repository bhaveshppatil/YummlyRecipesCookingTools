package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplicationyummlyrecipescookingtools.Fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_about_yummly.*

class AboutYummlyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_yummly)
        termsAndCondition.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yummly.com/terms"))
            startActivity(intent)
        }
        privacyNotice.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yummly.com/privacy"))
            startActivity(intent)
        }
        copyRight.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yummly.com/copyright"))
            startActivity(intent)
        }
        personalInfo.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yummly.com/terms"))
            startActivity(intent)
        }
        arrowImageInAbout.setOnClickListener {

            val intent=Intent(this,SettingsFragment::class.java)
            startActivity(intent)
        }
    }
}