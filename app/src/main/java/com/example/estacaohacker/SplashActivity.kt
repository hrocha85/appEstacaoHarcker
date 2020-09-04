package com.example.estacaohacker


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    //É um dos métodos presentes no ciclo de vida da Activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Abrir a LoginActivity após 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            //Iniciar uma intent - transição da tela Splash para a tela Login
            val intentLogin = Intent(this,LoginActivity::class.java)
            startActivity(intentLogin)
            finish()
        }, 3000)
    }
}

