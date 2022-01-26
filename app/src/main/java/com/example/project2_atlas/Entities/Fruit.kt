package com.example.project2_atlas.Entities

import androidx.room.Entity

@Entity(tableName="fruit_table")
data class Fruit (
    val name : String,
    val id : Int,
    val family : String,
    val genus:String,
    val order : String,
    val nutritions : Nutritions
        )