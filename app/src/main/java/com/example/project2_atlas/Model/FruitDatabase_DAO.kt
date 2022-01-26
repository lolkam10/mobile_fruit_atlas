package com.example.project2_atlas.Model
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project2_atlas.Entities.Fruits

@Dao
interface FruitDatabase_DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFruit(fruit:Fruits)
    @Query("SELECT * FROM  fruit_table")
    fun getAllFruitsFromDatabase():LiveData<List<Fruits>>
    @Query("SELECT * FROM  fruit_table WHERE fruitName == :name")
    fun getFruitsByName(name:String):LiveData<Fruits>
    @Query("SELECT * FROM  fruit_table WHERE favouritebool=1")
    fun getFavouriteFruitsFromDatabase():LiveData<List<Fruits>>
    @Query("SELECT * FROM  fruit_table WHERE fruitName LIKE '%' || :name || '%'")
    fun getSearchedFruitsFromDatabase(name:String):LiveData<List<Fruits>>
    @Query("UPDATE fruit_table SET favouritebool=1 WHERE fruitName=:name")
    fun addToFavourites(name: String)
    @Query("UPDATE fruit_table SET favouritebool=0 WHERE fruitName=:name")
    fun RemoveFromFavourites(name: String)
    @Query("DELETE FROM fruit_table")
    fun DeleteAllFruits()

}