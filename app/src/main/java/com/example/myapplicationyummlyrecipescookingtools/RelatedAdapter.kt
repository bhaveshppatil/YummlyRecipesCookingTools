package com.example.myapplicationyummlyrecipescookingtools

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationyummlyrecipescookingtools.Adapter.CLickListener
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ViewMoreItemClick
import com.example.myapplicationyummlyrecipescookingtools.Adapter.listner

class RelatedAdapter(
    val context: Context,
    var receipeModelList: MutableList<ReceipeModel>,
    val listner:listner

) : RecyclerView.Adapter<RelatedAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.recipe_view_more_layout, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model = receipeModelList.get(position)
        holder.setData(model)
        holder.relative.setOnClickListener {
            listner.onViewMoreItemClick(model)
        }
    }

    override fun getItemCount(): Int {
        return receipeModelList.size
    }

    fun updateData(modelList: MutableList<ReceipeModel>) {
        receipeModelList = modelList
        notifyDataSetChanged()
    }


    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var relative:RelativeLayout=itemView.findViewById(R.id.receipeItemView)
        var image: ImageView = itemView.findViewById(R.id.viewMoreImage)
        var recipeName: TextView = itemView.findViewById(R.id.tvViewMoreReceipeName)
        var recipeUser: TextView = itemView.findViewById(R.id.tvViewMoreUsername)
        var recipeCollection: TextView = itemView.findViewById(R.id.tvViewMorecollection)

        fun setData(model: ReceipeModel) {
            Glide.with(image).load(model.images).into(image)
            recipeName.text = model.recipeName
            recipeUser.text = model.user

        }

    }
}