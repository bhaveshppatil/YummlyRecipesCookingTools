package com.example.myapplicationyummlyrecipescookingtools.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplicationyummlyrecipescookingtools.Fragments.ExploreFragment
import com.example.myapplicationyummlyrecipescookingtools.Fragments.JustForYouFragment
import com.example.myapplicationyummlyrecipescookingtools.Fragments.ProUserFragment

internal class ViewPagerAdapter(
    context: Context,
    fragmentManager: FragmentManager,
    var totalTabs: Int
) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                JustForYouFragment()
            }
            1 -> {
                ExploreFragment()
            }
            2 -> {
                ProUserFragment()
            }
            else -> getItem(position)
        }
    }
}