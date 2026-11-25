package com.example.blackglass

import android.app.Activity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.webkit.WebChromeClient
import android.view.View

class MainActivity : Activity() {
    private lateinit var web: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = android.graphics.Color.rgb(5,6,7)
        window.navigationBarColor = android.graphics.Color.rgb(5,6,7)
        web = WebView(this)
        web.setBackgroundColor(android.graphics.Color.rgb(5,6,7))
        web.settings.javaScriptEnabled = true
        web.settings.domStorageEnabled = true
        web.settings.allowFileAccess = true
        web.settings.allowContentAccess = false
        web.settings.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_NEVER_ALLOW
        web.webViewClient = WebViewClient()
        web.webChromeClient = WebChromeClient()
        web.isFocusable = true
        web.isFocusableInTouchMode = true
        web.loadUrl("file:///android_asset/index.html")
        setContentView(web)
    }
    override fun onBackPressed() {
        if (::web.isInitialized && web.canGoBack()) web.goBack() else super.onBackPressed()
    }
}
