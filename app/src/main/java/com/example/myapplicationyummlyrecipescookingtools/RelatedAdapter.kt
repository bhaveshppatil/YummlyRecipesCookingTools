package com.example.myapplicationyummlyrecipescookingtools

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RelatedAdapter(val context: Context, var list:MutableList<Receipe>): RecyclerView.Adapter<RelatedAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.receipe_item_layout,parent,false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model=list.get(position)
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun updateData(modelList: MutableList<Receipe>) {
        list= modelList
        notifyDataSetChanged()
    }


    class RecipeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var image: ImageView = itemView.findViewById(R.id.imageRecipe)
        var recipeName: TextView
        var recipeUser: TextView
        var recipeCollection: TextView

        init {
            recipeName=itemView.findViewById(R.id.tvReceipeName)
            recipeUser=itemView.findViewById(R.id.username)
            recipeCollection=itemView.findViewById(R.id.collection)
        }

        fun setData(model:Receipe){
            Glide.with(image).load(model.Images).into(image)
            recipeName.text = model.RecipeName
            recipeUser.text=model.User
            recipeCollection.text=model.Collection


        }



    }
}