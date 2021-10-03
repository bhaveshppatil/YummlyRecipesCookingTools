package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplicationyummlyrecipescookingtools.R
import com.example.myapplicationyummlyrecipescookingtools.listsshop.listsActivity


class PremiumFragment : Fragment(R.layout.fragment_premium) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardView: Button = view.findViewById(R.id.btnGoPremium)

        cardView.setOnClickListener {
            val intent = Intent(context, listsActivity::class.java)
            startActivity(intent)
        }
    }
}