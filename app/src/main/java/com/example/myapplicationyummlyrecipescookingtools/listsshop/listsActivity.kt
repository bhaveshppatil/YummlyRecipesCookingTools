package com.example.myapplicationyummlyrecipescookingtools.listsshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplicationyummlyrecipescookingtools.R
import kotlinx.android.synthetic.main.activity_lists.*

class listsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lists)

        replaceFragment(planFragment())

        tvshop.setOnClickListener {
            replaceFragment(ShopFragment())
        }
        tvpantry.setOnClickListener {
            replaceFragment(PantryFragment())
        }
        tvplan.setOnClickListener {
            replaceFragment(planFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.rlrelate, fragment)
        fragmentTransaction.commit()
    }
}