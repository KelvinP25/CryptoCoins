package com.example.cryptocoins.data.repository

import com.example.cryptocoins.data.remoto.CoinApi
import com.example.cryptocoins.data.remoto.dto.Coin
import com.example.cryptocoins.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepository @Inject constructor(
    private val api: CoinApi
){
    fun getCoins(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coin = api.getCoin()
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error Occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar conexión a internet"))
        }
    }
}