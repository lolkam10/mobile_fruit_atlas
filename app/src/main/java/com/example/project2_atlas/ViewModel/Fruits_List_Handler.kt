package com.example.project2_atlas.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.Model.Database_Helper
import com.example.project2_atlas.Model.FruitDatabase_DAO
import com.example.project2_atlas.Model.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.security.auth.Subject

class Fruits_List_Handler(application: Application):AndroidViewModel(application) {
    private val database_Dao:FruitDatabase_DAO
    var fruit:Fruits
    var fruits:LiveData<List<Fruits>>
    init{
        database_Dao=Database_Helper.getInstance(application).databaseDao
        fruits=database_Dao.getAllFruitsFromDatabase()
        fruit=Fruits(0L,0L,"",false)

    }

    fun Search(name:String) :LiveData<List<Fruits>>{
        fruits=database_Dao.getSearchedFruitsFromDatabase(name)
        return fruits
    }

}