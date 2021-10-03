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
import com.example.myapplicationyummlyrecipescookingtools.R

class ReceipeAdapter(
    val context: Context,
    var receipeList: MutableList<ReceipeModel>,
    val clickListener: CLickListener

) : RecyclerView.Adapter<ReceipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceipeViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.receipe_item_layout, parent, false)
        return ReceipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReceipeViewHolder, position: Int) {
        val receipe = receipeList[position]
        holder.setData(receipe)

        holder.receipeItemView.setOnClickListener {
            clickListener.onReceipeClick(receipe)
        }
    }

    override fun getItemCount(): Int {
        return receipeList.size
    }

    fun updateData(receipeList: MutableList<ReceipeModel>) {
        this.receipeList = receipeList
        notifyDataSetChanged()
    }
}

class ReceipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val receipeItemView: RelativeLayout = itemView.findViewById(R.id.receipeItemView)

    private val tvReceipeName: TextView = itemView.findViewById(R.id.tvReceipeName)
    private val username: TextView = itemView.findViewById(R.id.username)
    private val collection: TextView = itemView.findViewById(R.id.collection)
    private val imgReceipe: ImageView = itemView.findViewById(R.id.imgReceipe)

    fun setData(receipe: ReceipeModel) {
        Glide.with(imgReceipe).load(receipe.images).into(imgReceipe)
        tvReceipeName.text = receipe.recipeName
        username.text = receipe.user
        collection.text = receipe.collection.toString()
    }
}