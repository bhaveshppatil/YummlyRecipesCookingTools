package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ProUserAdapter
import com.example.myapplicationyummlyrecipescookingtools.Adapter.userListener
import com.example.myapplicationyummlyrecipescookingtools.Models.ProUser
import com.example.myapplicationyummlyrecipescookingtools.Models.ProUsersModel
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream


class ProUserFragment : Fragment(R.layout.fragment_pro), userListener {
    private var userModelList = mutableListOf<ProUsersModel>()
    private lateinit var proUserAdapter: ProUserAdapter

    private val runnable = Runnable {
        readJson()
    }

    private fun readJson() {
        try {
            var inputStream: InputStream = context?.assets?.open("ProUsers.json")!!
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
        val type = object : TypeToken<ProUser?>() {}.type
        val proUser: ProUser = Gson().fromJson(json, type)
        userModelList = proUser.proUsers as MutableList<ProUsersModel>
        updateUi()
    }

    private fun updateUi() {
        activity?.runOnUiThread {
            proUserAdapter.updateData(userModelList)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.user_recycler_view)
        proUserAdapter = context?.let { ProUserAdapter(it, userModelList, this) }!!
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = proUserAdapter
        startBackground()
    }

    override fun onUserClick(proUsersModel: ProUsersModel) {

    }

}