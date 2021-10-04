package com.example.myapplicationyummlyrecipescookingtools.Fragments

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ProUserAdapter
import com.example.myapplicationyummlyrecipescookingtools.Adapter.UserListener
import com.example.myapplicationyummlyrecipescookingtools.Models.ProUsersModel
import com.example.myapplicationyummlyrecipescookingtools.Models.Prouser
import com.google.gson.Gson
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_pro.*
import kotlinx.android.synthetic.main.one_extra_layout.*
import retrofit2.http.Url
import java.io.InputStream
import java.net.URL

class ProUserFragment : Fragment(R.layout.fragment_pro), UserListener {
    private var userModelList = mutableListOf<ProUsersModel>()
    private lateinit var proUserAdapter: ProUserAdapter
    private lateinit var webView: WebView


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
        val type = object : TypeToken<Prouser?>() {}.type
        val proUser: Prouser = Gson().fromJson(json, type)
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
         webView = view.findViewById(R.id.proWebView)

        proUserAdapter = context?.let { ProUserAdapter(it, userModelList, this) }!!
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = proUserAdapter
        startBackground()
    }

    override fun onUserClick(proUsersModel: ProUsersModel) {

        webView.visibility=View.VISIBLE
        var url: String = proUsersModel.link
        startWebView(url)
    }
    private fun startWebView(url: String) {

        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        WebView.setWebContentsDebuggingEnabled(false)

        webView.scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
        webView.settings.builtInZoomControls = true
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true

        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Loading...")
        progressDialog.show()
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                if (progressDialog.isShowing) {
                    progressDialog.dismiss()
                }
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(context, "Error:$description", Toast.LENGTH_SHORT).show()
            }
        }
        webView.loadUrl(url)
    }
}