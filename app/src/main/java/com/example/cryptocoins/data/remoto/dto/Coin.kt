package com.example.cryptocoins.data.remoto.dto

data class Coin(
    val monedaId: Int = 0,
    val descripcion: String? = "",
    val valor: Double? = 0.00,
    val imageUrl : String? = ""
)