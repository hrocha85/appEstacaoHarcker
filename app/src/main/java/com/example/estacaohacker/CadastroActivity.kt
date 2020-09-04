package com.example.estacaohacker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //criar uma lista de opções para o spinner

        val listaGenero = arrayListOf("Selecione o gênero", "Feminino","Masculino","Outros")

        // criar um adaptador para o spinner

        val generoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,listaGenero
        )

        spnCadastroGenero.adapter = generoAdapter

        btnCadastroCadastar.setOnClickListener {

            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase()
            val senha = edtCadastroSenha.text.toString().trim()
            val genero = spnCadastroGenero.selectedItem.toString()

            // validação dos campos

            if (nome.isEmpty() || genero == listaGenero [0]) {

                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG)
                    .show()
            } else {
                //neste pontos os campos foram preenchidos corretamente
                val sharedPrefs = getSharedPreferences("cadastro_$email",
                Context.MODE_PRIVATE)

                //obtendo a referencia de edição do arquivo
                val editPrefs = sharedPrefs.edit()

                editPrefs.putString("NOME",nome)
                editPrefs.putString("SOMBRENOME",sobrenome)
                editPrefs.putString("EMAIL",email)
                editPrefs.putString("SENHA",senha)
                editPrefs.putString("GENERO",genero)

                //Salvar os dados no arquivo de shared preferences

                editPrefs.apply()

                // abrir a tela main

                val mIntent = Intent(this, MainActivity::class.java)

                // passando dados atraves de intents

                mIntent.putExtra("INTENT_EMAIL", email)

                startActivity(mIntent)

                finishAffinity()

            }


        }

    }
}