package com.example.project2_atlas.Model

import com.example.project2_atlas.Entities.Fruit
import retrofit2.awaitResponse

class Repo {
    companion object {

        suspend fun getAll(): List<Fruit>? {
            return Retro.api.getAll().awaitResponse().body()
        }

        suspend fun getFruitByFamily(family:String): List<Fruit>? {
            return Retro.api.getFruitByFamily(family).awaitResponse().body()
        }

        suspend fun getFruitByName(name:String):Fruit? {
            return Retro.api.getFruitByName(name).awaitResponse().body()
        }
    }
}