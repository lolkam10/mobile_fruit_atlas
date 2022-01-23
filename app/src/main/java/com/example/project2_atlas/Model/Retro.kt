package com.example.project2_atlas.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BaseUrl = "https://www.fruityvice.com/"
object Retro {
    private val retro by lazy{
        Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api : FruitAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create())
            .build().create(FruitAPI::class.java)
    }
}