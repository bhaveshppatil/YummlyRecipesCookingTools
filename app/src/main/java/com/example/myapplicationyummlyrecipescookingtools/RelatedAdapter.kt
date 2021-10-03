package com.example.myapplicationyummlyrecipescookingtools

import android.content.Context
import android.os.Build.VERSION_CODES.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.R
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ViewMoreItemClick

class RelatedAdapter(
    val context: Context,
    var receipeModelList: MutableList<ReceipeModel>,
    val clickListener: ViewMoreItemClick

) : RecyclerView.Adapter<RelatedAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.related_item_view, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val model = receipeModelList[position]
        holder.setData(model)

        holder.relatedItemView.setOnClickListener {
            clickListener.onItemClick(model)
        }
    }

    override fun getItemCount(): Int {
        return receipeModelList.size
    }

    fun updateData(receipeModelList: MutableList<ReceipeModel>) {
        this.receipeModelList = receipeModelList
        notifyDataSetChanged()
    }


    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val relatedItemView: RelativeLayout = itemView.findViewById(R.id.relatedItemView)
        private var image: ImageView = itemView.findViewById(R.id.ivReceipe)
        private var recipeName: TextView = itemView.findViewById(R.id.tvReceipe)
        var recipeUser: TextView = itemView.findViewById(R.id.tvUserID)

        fun setData(receipeModel: ReceipeModel) {
            Glide.with(image).load(receipeModel.images).into(image)
            recipeName.text = receipeModel.recipeName
            recipeUser.text = receipeModel.user

        }
    }
}