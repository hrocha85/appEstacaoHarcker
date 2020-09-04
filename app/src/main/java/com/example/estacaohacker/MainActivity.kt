package com.example.estacaohacker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = intent.getStringExtra("INTENT_EMAIL")

        //Abrindo o arquivo de shared preferences

        val sharedPrefs = getSharedPreferences( "cadastro_$email",
        Context.MODE_PRIVATE)

        //Recuperar os dados do Shared Preferences

        val nome = sharedPrefs.getString("NOME","Anônimo")
        val sobrenome = sharedPrefs.getString("SOBRENOME","")
        val genero = sharedPrefs.getString("GENERO","Outros")

        txvMainNome.text="$nome $sobrenome"
        txvMainEmail.text= email
        txvMainGenero.text= genero

        btnMainSite.setOnClickListener {

            val mIntent = Intent (this, WebActivity::class.java)
            startActivity(mIntent)

        }
        btnMainSair.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Você realmente deseja sair?")
                .setPositiveButton("Sim"){_,_->
                    val mIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mIntent)

                    finishAffinity()

                }

                .setNeutralButton("Cancelar"){_,_ ->}
                .setCancelable(false)
                .create()
                .show()

        }


    }
}