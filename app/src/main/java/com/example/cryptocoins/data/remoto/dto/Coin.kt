package com.example.cryptocoins.data.remoto.dto

data class Coin(
    val monedaId: Int = 0,
    val descricion: String? = "",
    val valor: Double = 0.0,
    val imagenUrl : String = ""
)