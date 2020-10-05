package com.example.presentation.screens

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.presentation.R

const val URL = "http://www.icndb.com/api/"

class FragmentWeb : Fragment() {
    private lateinit var webView: WebView

    companion object {
        fun getInstance(fragmentManager: FragmentManager): FragmentWeb {
            val fragmentWeb: FragmentWeb? =
                fragmentManager.findFragmentByTag(FragmentWeb::class.simpleName) as? FragmentWeb

            return fragmentWeb ?: FragmentWeb()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        webView.saveState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.web_view_api)
        webView.settings.javaScriptEnabled = true
        webView.settings.setSupportZoom(true)
        webView.settings.builtInZoomControls = true

        savedInstanceState?.let {
            webView.restoreState(it)
        } ?: run {
            webView.loadUrl(URL)
        }
    }
}