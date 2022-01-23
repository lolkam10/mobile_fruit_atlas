package com.example.project2_atlas.Model

import retrofit2.awaitResponse

class Repo {
    companion object {

        suspend fun getAll(): List<Fruit>? {
            return Retro.api.getAll().awaitResponse().body()
        }

        suspend fun getAllSensorsByStation(family:String):List<Fruit>? {

            return Retro.api.getFruitByFamily(family).awaitResponse().body()
        }
    }
}