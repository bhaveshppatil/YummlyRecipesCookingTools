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
import com.example.myapplicationyummlyrecipescookingtools.Models.ArticlesModel
import com.example.myapplicationyummlyrecipescookingtools.Models.ReceipeModel
import com.example.myapplicationyummlyrecipescookingtools.R

class ArticlesAdapter(
    val context: Context,
    var articleModelList: MutableList<ArticlesModel>,
    val clickListener: CLickListener

) : RecyclerView.Adapter<ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.articles_item_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

        val articlesModel = articleModelList[position]
        holder.setData(articlesModel)

        holder.articleItemView.setOnClickListener {
            clickListener.onArticleClick(articlesModel)
        }
    }

    override fun getItemCount(): Int {
        return articleModelList.size
    }

    fun updateData(articleModelList: MutableList<ArticlesModel>) {
        this.articleModelList = articleModelList
        notifyDataSetChanged()
    }
}

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val articleItemView: RelativeLayout = itemView.findViewById(R.id.articleItemView)
    private val tvArticleName: TextView = itemView.findViewById(R.id.tvArticleName)
    private val articleCount: TextView = itemView.findViewById(R.id.articleCount)
    private val imgArticle: ImageView = itemView.findViewById(R.id.imgArticle)

    fun setData(articlesModel: ArticlesModel) {
        Glide.with(imgArticle).load(articlesModel.images).into(imgArticle)
        tvArticleName.text = articlesModel.articleName
        articleCount.text = articlesModel.count
    }
}
