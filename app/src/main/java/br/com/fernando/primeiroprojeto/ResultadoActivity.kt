package br.com.fernando.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import br.com.fernando.primeiroprojeto.extensions.format
import br.com.fernando.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Disponibilizar o botão de retornar a tela anterior
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Recebendo os dados da tela anterior
        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)

        //Exibir alerta do android
        //Toast.makeText(this, peso, Toast.LENGTH_SHORT).show()

        calcularIMC(peso.toDouble(), altura.toDouble())
    }

    //Método de finalizar a tela após a finalização pelo botão de voltar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun calcularIMC(peso: Double, altura: Double) {
        val imc = peso / (altura * altura)

        /*if (imc < 17) {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.magreza.i)
        } else if (imc < 18.5){
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.abaixo)
        } else if (imc < 24.9) {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.ideal)
        } else if (imc < 29.9) {
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.sobre)
        } else if (imc < 34.9){
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.obesidade)
        } else if (imc < 39.9){
            tvIMC.setText(imc.toString())
            setImagem(R.drawable.obesidade)
        } else {

        }*/

        tvIMC.text = imc.format(0)

        when (imc) {
            in 0..17 -> {
                setImagem(R.drawable.magreza)
                tvIMCDescricao.text = getString(R.string.label_magreza)
            }
            in 17.1..18.59 -> {
                setImagem(R.drawable.abaixo)
                tvIMCDescricao.text = getString(R.string.label_abaixo_peso)
            }
            in 18.6..24.9 -> {
                setImagem(R.drawable.ideal)
                tvIMCDescricao.text = getString(R.string.label_peso_ideal)
            }
            in 24.91..29.9 -> {
                setImagem(R.drawable.sobre)
                tvIMCDescricao.text = getString(R.string.label_sobrepeso)
            }
            in 29.91..34.9 -> {
                setImagem(R.drawable.obesidade)
                tvIMCDescricao.text = getString(R.string.label_obesidade1)
            }
            in 34.91..99.0 -> {
                setImagem(R.drawable.obesidade)
                tvIMCDescricao.text = getString(R.string.label_obesidade2)
            }
            else -> {}
        }

    }

    private fun setImagem(resourceId: Int) {
        ivIMC.setImageDrawable(
                ContextCompat.getDrawable(this,resourceId))
    }
}
