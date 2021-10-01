package com.example.myapplicationyummlyrecipescookingtools.ProTab

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplicationyummlyrecipescookingtools.Adapter.userListener
import com.example.myapplicationyummlyrecipescookingtools.R

class ProUserAdapter(
    val context: Context,
    var proUsersModelList: MutableList<ProUsersModel>,
    val userListener: userListener
) : RecyclerView.Adapter<proUserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): proUserViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.prouser_item_layout, parent, false)
        return proUserViewHolder(view)
    }

    override fun onBindViewHolder(holder: proUserViewHolder, position: Int) {
        val proUsersModel = proUsersModelList[position]
        holder.setData(proUsersModel)

        holder.userView.setOnClickListener {
            userListener.onUserClick(proUsersModel)
        }
    }

    override fun getItemCount(): Int {
        return proUsersModelList.size
    }

    fun updateData(proUsersModelList: MutableList<ProUsersModel>) {
        this.proUsersModelList = proUsersModelList
        notifyDataSetChanged()
    }
}

class proUserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val userView: RelativeLayout = itemView.findViewById(R.id.userView)
    private val caption: TextView = itemView.findViewById(R.id.tvCaptionName)
    private val username: TextView = itemView.findViewById(R.id.tvUsername)
    private val userProfile: ImageView = itemView.findViewById(R.id.userProfilePic)
    private val userArt: ImageView = itemView.findViewById(R.id.imgUserArt)


    fun setData(proUsersModel: ProUsersModel) {
        Glide.with(userProfile).load(proUsersModel.userProfile).into(userProfile)
        Glide.with(userArt).load(proUsersModel.image).into(userArt)
        caption.text = proUsersModel.caption
        username.text = proUsersModel.username

    }
}
