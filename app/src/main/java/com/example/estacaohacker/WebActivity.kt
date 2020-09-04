package com.example.estacaohacker

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*


class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //Habilitando a execução de codigo java script no WebView
        wbvWeb.settings.javaScriptEnabled = true

        //carregando url
        wbvWeb.loadUrl("http://br.cellep.com/estacaohack/")

        wbvWeb.webViewClient = WebViewClient()

    }
}