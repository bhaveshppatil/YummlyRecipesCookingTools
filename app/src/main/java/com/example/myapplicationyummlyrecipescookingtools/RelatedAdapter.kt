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
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ViewMoreItemClick

class RelatedAdapter(
    val context: Context,
    var receipeModelList: MutableList<Receipe>

) : RecyclerView.Adapter<RelatedAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.recipe_view_more_layout, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model = receipeModelList.get(position)
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return receipeModelList.size
    }

    fun updateData(modelList: MutableList<Receipe>) {
        receipeModelList = modelList
        notifyDataSetChanged()
    }


    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.viewMoreImage)
        var recipeName: TextView = itemView.findViewById(R.id.tvViewMoreReceipeName)
        var recipeUser: TextView = itemView.findViewById(R.id.tvViewMoreUsername)
        var recipeCollection: TextView = itemView.findViewById(R.id.tvViewMorecollection)

        fun setData(model: Receipe) {
            Glide.with(image).load(model.Images).into(image)
            recipeName.text = model.RecipeName
            recipeUser.text = model.User
            recipeCollection.text = model.Collection


        }

    }
}