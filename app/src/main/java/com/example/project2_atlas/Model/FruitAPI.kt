package com.example.project2_atlas.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FruitAPI {
    @GET("api/fruit/all")
    fun getAll(): Call<List<Fruit>>

    @GET("api/fruit/{name}")
    fun getFruitByName(@Path("name") name:String): Call<Fruit>

    @GET("api/fruit/family/{family}")
    fun getFruitByFamily(@Path("family") family:String): Call<List<Fruit>>

}