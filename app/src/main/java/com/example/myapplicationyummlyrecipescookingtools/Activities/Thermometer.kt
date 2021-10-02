package com.example.myapplicationyummlyrecipescookingtools.Activities

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationyummlyrecipescookingtools.R
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.activity_thermometer.*
import kotlinx.android.synthetic.main.activity_thermometer.webView

class Thermometer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thermometer)

        btnAddThermometer.setOnClickListener {
            webView.visibility = View.VISIBLE
            startWebView("https://www.yummly.com/thermometer")
        }
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

        val progressDialog = ProgressDialog(this)
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
                Toast.makeText(this@Thermometer, "Error:$description", Toast.LENGTH_SHORT).show()
            }
        }
        webView.loadUrl(url)
    }
}