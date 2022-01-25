package com.example.project2_atlas.Model
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.project2_atlas.Entities.Fruits
@Dao
interface FruitDatabase_DAO {
    @Insert
    fun insertFruit(fruit:Fruits)
    @Query("SELECT * FROM  fruit_table")
    fun getAllFruitsFromDatabase():LiveData<List<Fruits>>
    @Query("SELECT * FROM  fruit_table WHERE favouritebool=1")
    fun getFavouriteFruitsFromDatabase():LiveData<List<Fruits>>
    @Query("SELECT * FROM  fruit_table WHERE fruitName LIKE '%' || :name || '%'")
    fun getSearchedFruitsFromDatabase(name:String):LiveData<List<Fruits>>
    @Query("DELETE FROM fruit_table")
    fun DeleteAllFruits()

}