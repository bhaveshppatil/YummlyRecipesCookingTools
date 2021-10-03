package com.example.myapplicationyummlyrecipescookingtools.listsshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.R

class PlanAdapter(private var images:List<Int>):RecyclerView.Adapter<PlanAdapter.PlanviewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanAdapter.PlanviewHolder {
      return PlanviewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_plan,parent,false))

   }

    override fun onBindViewHolder(holder: PlanAdapter.PlanviewHolder, position: Int) {
         holder.img.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
      return images.size
    }

    class PlanviewHolder(itemview:View):RecyclerView.ViewHolder(itemview){

        val img:ImageView=itemview.findViewById(R.id.imgvieww)
    }
}