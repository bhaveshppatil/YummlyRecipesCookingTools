package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplicationyummlyrecipescookingtools.*



class SettingsFragment : Fragment(R.layout.fragment_thermometer) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myAccount:TextView=view.findViewById(R.id.myAccount)
        val subscription:TextView=view.findViewById(R.id.subscription)
        val preferences:TextView=view.findViewById(R.id.preferences)
        val aboutYummly:TextView=view.findViewById(R.id.aboutYummly)
        val feedback:TextView=view.findViewById(R.id.feedback)
        myAccount.setOnClickListener {
            val intent= Intent(context, MyAccountActivity::class.java)
            startActivity(intent)
        }
        subscription.setOnClickListener {
            val intent= Intent(context, PrimeMemberActivity::class.java)
            startActivity(intent)
        }
        preferences.setOnClickListener {
            val intent= Intent(context, PreferencesActivity::class.java)
            startActivity(intent)
        }
        aboutYummly.setOnClickListener {
            val intent= Intent(context, AboutYummlyActivity::class.java)
            startActivity(intent)
        }
        feedback.setOnClickListener {
            val intent= Intent(context, FeedbackActivity::class.java)
            startActivity(intent)
        }
    }

}