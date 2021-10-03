package com.example.myapplicationyummlyrecipescookingtools.listsshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplicationyummlyrecipescookingtools.R
import kotlinx.android.synthetic.main.fragment_plan.*
import me.relex.circleindicator.CircleIndicator3


class planFragment : Fragment(R.layout.fragment_plan) {

    private var imglist= mutableListOf<Int>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addToLost()
        flcontainer.adapter=PlanAdapter(imglist)
        flcontainer.orientation= ViewPager2.ORIENTATION_HORIZONTAL

        val indicator=view.findViewById<CircleIndicator3>(R.id.ciindicator)
        indicator.setViewPager(flcontainer)
    }
    private fun addToLost(){
        imglist.add(R.drawable.planimg1)
        imglist.add(R.drawable.planimg2)
        imglist.add(R.drawable.planimg3)
    }



}