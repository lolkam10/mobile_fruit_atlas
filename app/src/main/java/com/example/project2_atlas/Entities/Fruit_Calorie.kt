package com.example.project2_atlas.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName="calorie_table")
data class Fruit_Calorie(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="idCal")
    var fruitID: Long=0L,
    @ColumnInfo(name="fruitNameCal")
    var fruitName: String,
    @ColumnInfo(name = "calorieCount")
    var calorie_count:Double,
    @ColumnInfo(name = "massInGrams")
    var mass:Double
                             )
