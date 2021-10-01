package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.os.Bundle
import android.view.View
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.Adapter.SearchListener
import com.example.myapplicationyummlyrecipescookingtools.R
import com.example.myapplicationyummlyrecipescookingtools.SearchReceipe.SearchAdapter
import com.example.myapplicationyummlyrecipescookingtools.SearchReceipe.SearchDataModel
import com.example.myapplicationyummlyrecipescookingtools.SearchReceipe.SearchModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.search_item_view.*
import java.io.InputStream


class SearchFragment : Fragment(R.layout.fragment_search), SearchListener {
    private var searchModelList = mutableListOf<SearchModel>()
    private lateinit var searchAdapter: SearchAdapter

    private val runnable = Runnable {
        readJson()
    }

    private fun readJson() {
        try {
            var inputStream: InputStream = context?.assets?.open("SearchReceipe.json")!!
            var data = inputStream.read()
            var builder: StringBuilder = StringBuilder()
            while (data != -1) {
                val ch = data.toChar()
                builder.append(ch)
                data = inputStream.read()
            }
            buildPojoFromJson(builder.toString())

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun startBackground() {
        val thread = Thread(runnable)
        thread.start()
    }

    private fun buildPojoFromJson(json: String) {
        val type = object : TypeToken<SearchDataModel?>() {}.type
        val searchDataModel: SearchDataModel = Gson().fromJson(json, type)
        searchModelList = searchDataModel.search as MutableList<SearchModel>
        updateUi()
    }

    private fun updateUi() {
        activity?.runOnUiThread {
            searchAdapter.updateData(searchModelList)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.search_recycler_view)
        searchAdapter = context?.let { SearchAdapter(it, searchModelList, this) }!!
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = searchAdapter
        startBackground()
    }

    override fun onSearchItemClick(searchModel: SearchModel) {

        val mediaController:MediaController = MediaController(context)
        videoView.setMediaController(mediaController)

    }
}