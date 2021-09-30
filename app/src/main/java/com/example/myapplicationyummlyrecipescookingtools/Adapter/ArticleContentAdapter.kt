package com.example.myapplicationyummlyrecipescookingtools.Adapter

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
import com.example.myapplicationyummlyrecipescookingtools.Models.VegetarianModel
import com.example.myapplicationyummlyrecipescookingtools.R

class ArticleContentAdapter(
    val context: Context,
    var vegetarianList: MutableList<VegetarianModel>,
    val vegetarianListener: VegetarianListener

) : RecyclerView.Adapter<VegetarianViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VegetarianViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.receipe_item_layout, parent, false)
        return VegetarianViewHolder(view)
    }

    override fun onBindViewHolder(holder: VegetarianViewHolder, position: Int) {
        val vegetarian = vegetarianList[position]
        holder.setData(vegetarian)

        holder.receipeItemView.setOnClickListener {
            vegetarianListener.onContentClick(vegetarian)
        }
    }

    override fun getItemCount(): Int {
        return vegetarianList.size
    }
    fun updateData(vegetarianList: MutableList<VegetarianModel>) {
        this.vegetarianList = vegetarianList
        notifyDataSetChanged()
    }
}

class VegetarianViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val receipeItemView: RelativeLayout = itemView.findViewById(R.id.receipeItemView)
    private val tvReceipeName: TextView = itemView.findViewById(R.id.tvReceipeName)
    private val username: TextView = itemView.findViewById(R.id.username)
    private val imgReceipe: ImageView = itemView.findViewById(R.id.imgReceipe)

    fun setData(vegetarianModel: VegetarianModel) {
        Glide.with(imgReceipe).load(vegetarianModel.images).into(imgReceipe)
        tvReceipeName.text = vegetarianModel.articleName
        username.text = vegetarianModel.tag
    }
}