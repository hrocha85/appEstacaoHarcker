package com.example.estacaohacker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Executando o clique do botão entrar
        btnLoginEntrar.setOnClickListener {

            //Capturar dados digitados pelo usuário
            val email = edtEmail.text.toString().trim().toLowerCase()
            val senha = edtSenha.text.toString().trim()

            //Validação dos campos
            if (email.isEmpty()){
                edtEmail.error = "Campo obrigatório!"
                edtEmail.requestFocus()
            }else if (senha.isEmpty()){
                edtSenha.error = "Campo obrigatório!"
                edtSenha.requestFocus()
            }else{

                //Abrindo o arquivo de shared preferences

                val sharedPrefs = getSharedPreferences( "cadastro_$email",
                    Context.MODE_PRIVATE)

                //Recuperar os dados do Shared Preferences

                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")


                if (email == emailPrefs && senha == senhaPrefs ) {
                    // Caso a senha e o email esteja correta

                    // Exibindo o Toast (alerta curto) para o usuário logado
                    Toast.makeText(this, "Usuário Logado", Toast.LENGTH_LONG).show()

                    // Criar a intent para ir para a Tela Main
                    val mIntent = Intent(this, MainActivity::class.java)

                    // passando
                    mIntent.putExtra("INTENT_EMAIL",email)

                    // Iniciar activity
                    startActivity(mIntent)

                    // Encerrar a Activity
                    finish()
                }
                else {
                    // Caso a senha ou o email esteja errado
                    Toast.makeText(this, "Email ou senha inválidos!", Toast.LENGTH_LONG).show()

                }
            }
        }

        btnCadastrar.setOnClickListener {
            // Abrir a tela de cadastro
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
        }
    }
}
