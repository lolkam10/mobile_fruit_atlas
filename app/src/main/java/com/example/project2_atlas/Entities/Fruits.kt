package com.example.project2_atlas.Entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(tableName="fruit_table")
data class Fruits(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var fruitID: Long=0L,
    @ColumnInfo(name="apiId")
    var apiID: Long=0L,
    @ColumnInfo(name="fruitName")
    var fruitName: String,
    @ColumnInfo(name = "favouritebool")
    var favourite:Boolean
)
