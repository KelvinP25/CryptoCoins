package com.example.cryptocoins.di

import com.example.cryptocoins.data.remoto.CoinApi
import com.example.cryptocoins.data.repository.CoinRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    @Singleton
    fun provideCoinApi(moshi: Moshi): CoinApi{
        return Retrofit.Builder()
            .baseUrl("http://kelvinp.somee.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinApi: CoinApi): CoinRepository{
        return CoinRepository(coinApi)
    }
}