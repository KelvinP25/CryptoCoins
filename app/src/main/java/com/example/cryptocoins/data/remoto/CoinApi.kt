package com.example.cryptocoins.data.remoto

import com.example.cryptocoins.data.remoto.dto.Coin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CoinApi {
    @GET("/Coinst")
    suspend fun getCoin(): List<Coin>

    @POST("/Coinst")
    suspend fun postCoin(@Body coin: Coin): Response<Coin>
}