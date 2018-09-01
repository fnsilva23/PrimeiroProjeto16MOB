package br.com.fernando.primeiroprojeto.extensions

import android.widget.EditText

fun EditText.meuClear() = this.setText("")
fun EditText.value() = this.text.toString()