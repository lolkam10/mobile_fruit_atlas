package com.example.project2_atlas.Model

import retrofit2.awaitResponse

class Repo {

    companion object {
        private val nutrition = Nutrition(1,1,1,1,1)
        private val fruit = Fruit("asa",1,"sas","asas","ass", nutrition)
        private val lista : List<Fruit> = listOf(fruit)

        suspend fun getAll(): List<Fruit>? {
            return Retro.api.getAll().awaitResponse().body()?: lista
        }

        suspend fun getAllSensorsByStation(family:String):List<Fruit>? {

            return Retro.api.getFruitByFamily(family).awaitResponse().body()
        }
    }
}