package com.example.project2_atlas.ViewModel.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.Model.Database_Helper
import com.example.project2_atlas.Model.FruitDatabase_DAO
import com.example.project2_atlas.Model.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Main_ScreenVM (application: Application) : AndroidViewModel(application) {
    val fruitDAO : FruitDatabase_DAO = Database_Helper.getInstance(application).databaseDao
    val fruitsFromDB : LiveData<List<Fruits>> = fruitDAO.getAllFruitsFromDatabase()

    fun makeDB(){
        viewModelScope.launch(Dispatchers.IO) {
            println(fruitDAO.CountFruitRows())
            if (fruitDAO.CountFruitRows()==0) {
                val fruits = Repo.getAll()
                val s = fruits!!.size - 1
                for (i in 0..s) {
                    val apiID = fruits[i].id.toLong()
                    val fruitName = fruits[i].name
                    val newFruit = Fruits(0, apiID, fruitName, false)
                    fruitDAO.insertFruit(newFruit)
                }
            }
        }
    }
}