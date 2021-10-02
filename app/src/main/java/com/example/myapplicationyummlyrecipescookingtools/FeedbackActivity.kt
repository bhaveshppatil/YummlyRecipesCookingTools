package com.example.myapplicationyummlyrecipescookingtools

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplicationyummlyrecipescookingtools.Fragments.SettingsFragment
import kotlinx.android.synthetic.main.activity_feedback.*

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        arrowImageInFeeback.setOnClickListener {
            val intent=Intent(this,SettingsFragment::class.java)

            startActivity(intent)
        }
        feebackSession.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.yummly.android&hl=en_IN&gl=US"))
           startActivity(intent)
        }
        rateApp.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.yummly.android&hl=en_IN&gl=US"))
            startActivity(intent)
        }
        faq.setOnClickListener {
            val intent=Intent(Intent.ACTION_VIEW, Uri.parse("https://help.yummly.com/hc/en-us/articles/203473810-Android-app-overview"))
            startActivity(intent)
        }
        loveYummly.setOnClickListener {
            val shareApp="Download the App Now : https://play.google.com/store/apps/details?id=com.yummly.android&hl=en_IN&gl=US"
            val soganApp="Be A Better Cook"
            val intent=Intent(Intent.ACTION_SEND)
            intent.type="text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT,soganApp)
            intent.putExtra(Intent.EXTRA_TEXT,shareApp)
            startActivity(intent)
        }

    }
}