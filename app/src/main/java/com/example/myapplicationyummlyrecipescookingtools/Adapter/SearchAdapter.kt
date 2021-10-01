package com.example.myapplicationyummlyrecipescookingtools.Adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.R
import com.example.myapplicationyummlyrecipescookingtools.Models.SearchModel

class SearchAdapter(
    val context: Context,
    var searchModelList: MutableList<SearchModel>,
    val searchListener: SearchListener

) : RecyclerView.Adapter<SearchDataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchDataViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.search_item_view, parent, false)
        return SearchDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchDataViewHolder, position: Int) {
        val searchModel = searchModelList[position]
        holder.setData(searchModel)

        holder.searchItemView.setOnClickListener {
            searchListener.onSearchItemClick(searchModel)
        }

    }

    override fun getItemCount(): Int {
        return searchModelList.size
    }

    fun updateData(searchModelList: MutableList<SearchModel>) {
        this.searchModelList = searchModelList
        notifyDataSetChanged()
    }

}

class SearchDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val searchItemView: RelativeLayout = itemView.findViewById(R.id.searchItemView)
    private val receipeName: TextView = itemView.findViewById(R.id.receipeName)
    private val videoView: VideoView = itemView.findViewById(R.id.videoView)

    fun setData(searchModel: SearchModel) {
        var url: String = searchModel.videoUrl
        val uri: Uri = Uri.parse(url)

        videoView.setVideoURI(uri)
        videoView.start()
        receipeName.text = searchModel.receipe
    }
}
