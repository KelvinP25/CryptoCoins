package com.example.cryptocoins.data.remoto

import com.example.cryptocoins.data.remoto.dto.Coin
import retrofit2.http.GET

interface CoinApi {
    @GET("/Coinst")
    suspend fun getCoin(): List<Coin>
}