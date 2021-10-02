package com.example.myapplicationyummlyrecipescookingtools.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_yummly_welcome.*

class YummlyWelcome : AppCompatActivity() {

    private lateinit var mauth: FirebaseAuth
    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = mauth.currentUser
        if (user != null) {
            val intent = Intent(this, HomeScreen::class.java)
            startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yummly_welcome)

//        val actionBar: ActionBar? = supportActionBar
//        actionBar!!.hide()

        mauth = FirebaseAuth.getInstance()

        btnNewUser.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        btnAlreadyUser.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        btnThermometer.setOnClickListener {
            Toast.makeText(this, "Thermometer Activated", Toast.LENGTH_SHORT).show()
        }
        tvSkip.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}