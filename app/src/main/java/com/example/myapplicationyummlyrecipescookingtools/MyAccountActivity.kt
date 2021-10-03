package com.example.myapplicationyummlyrecipescookingtools

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.myapplicationyummlyrecipescookingtools.Activities.HomeScreen
import com.example.myapplicationyummlyrecipescookingtools.Fragments.SettingsFragment
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_my_account.*
import kotlinx.android.synthetic.main.activity_thermometer.*


class MyAccountActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    override fun onStart() {
        super.onStart()
        val user: FirebaseUser? = mAuth.currentUser
        tvUser.text = user!!.displayName
        Glide.with(profilePic).load(user.photoUrl).into(profilePic)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)
        mAuth = FirebaseAuth.getInstance()

        btnLogout.setOnClickListener {
            signOut()
        }

        arrowImageInMyAccount.setOnClickListener {
            val intent = Intent(this, SettingsFragment::class.java)
            startActivity(intent)
        }

        swAutoplay.setOnClickListener {
            if (swAutoplay.isChecked) {
                Toast.makeText(this, "Autoplay Videos On", Toast.LENGTH_SHORT).show()
            }
        }
        swReceipeImages.setOnClickListener {
            if (swReceipeImages.isChecked) {
                Toast.makeText(this, "Receipe Images On", Toast.LENGTH_SHORT).show()
            }
        }
        swVoiceControl.setOnClickListener {
            if (swVoiceControl.isChecked) {
                Toast.makeText(this, "Voice Control On", Toast.LENGTH_SHORT).show()
            }
        }
        swYummly.setOnClickListener {
            if (swYummly.isChecked) {
                Toast.makeText(this, "Yummly Notification On", Toast.LENGTH_SHORT).show()
            }
        }


        learnMore.setOnClickListener {
            startWebView("https://www.yummly.com/subscription/plans")
        }

        deleteAccount.setOnClickListener {
            accountWebView.visibility = View.VISIBLE
            startWebView("https://www.yummly.com/settings#")
        }

    }

    private fun startWebView(url: String) {

        val webView: WebView = findViewById(R.id.accountWebView)
        accountWebView.visibility = View.VISIBLE
        val settings = webView.settings
        settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        WebView.setWebContentsDebuggingEnabled(false)

        webView.scrollBarStyle = View.SCROLLBARS_OUTSIDE_OVERLAY
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
                Toast.makeText(this@MyAccountActivity, "Error:$description", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        webView.loadUrl(url)
    }

    private fun signOut() {
        mAuth.signOut()
        googleSignInClient.signOut().addOnCompleteListener(
            this
        ) {
            val intent = Intent(this@MyAccountActivity, HomeScreen::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
    }
}