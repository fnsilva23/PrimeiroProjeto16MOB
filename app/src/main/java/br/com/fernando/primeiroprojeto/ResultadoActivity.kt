package br.com.fernando.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fernando.primeiroprojeto.utils.ConstantesExtra

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Recebendo os dados da tela anterior
        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)

        //Exibir alerta do android
        Toast.makeText(this, peso, Toast.LENGTH_SHORT).show()

    }
}
