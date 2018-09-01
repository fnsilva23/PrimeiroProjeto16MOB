package br.com.fernando.primeiroprojeto.extensions

fun Double.format(digitos: Int) = String.format("%.${digitos}f",this)