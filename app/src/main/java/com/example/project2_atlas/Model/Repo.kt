package com.example.project2_atlas.Model

import com.example.project2_atlas.Entities.Fruit
import retrofit2.awaitResponse

class Repo {

    companion object {
        private val nutrition = Nutrition(1,1,1,1,1)
        private val fruit = Fruit("asa",1,"sas","asas","ass", nutrition)
        private val lista : List<Fruit> = listOf(fruit)

        suspend fun getAll(): List<Fruit>? {
            return Retro.api.getAll().awaitResponse().body()?: lista
        }

        suspend fun getFruitByFamily(family:String): List<Fruit>? {
            return Retro.api.getFruitByFamily(family).awaitResponse().body()
        }

        suspend fun getFruitByName(name:String):Fruit? {
            return Retro.api.getFruitByName(name).awaitResponse().body()
        }
    }
}