package com.example.cryptocoins.data.remoto.dto

data class CoinListState(
    val isLoading: Boolean = false,
    val exchanges: List<Coin> = emptyList(),
    val error: String = ""
)