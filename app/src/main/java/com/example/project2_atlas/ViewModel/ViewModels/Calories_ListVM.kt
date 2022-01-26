package com.example.project2_atlas.ViewModel.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Entities.Fruit_Calorie
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.Model.Database_Helper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Calories_ListVM (application: Application) : AndroidViewModel(application) {
    private val database_Dao = Database_Helper.getInstance(application).databaseDao
    val allFruits : LiveData<List<Fruits>> = database_Dao.getAllFruitsFromDatabase()
    val allFruitsCalorie : LiveData<List<Fruit_Calorie>> = database_Dao.getAllFruitsCalorieFromDatabase()
    val _chosenFruit : MutableLiveData<Fruits> = MutableLiveData()
    val chosenFruit : LiveData<Fruits>
        get() {
            return _chosenFruit
        }
    val _chosenFruitCalorie : MutableLiveData<Fruit_Calorie> = MutableLiveData()
    val chosenFruitCalorie : LiveData<Fruit_Calorie>
        get() {
            return _chosenFruitCalorie
        }
    fun addToCalorieList(fruitcalorie:Fruit_Calorie){
    viewModelScope.launch(Dispatchers.IO) {
        database_Dao.insertCalorie(fruitcalorie)
    }
    }
    fun removeFromListCalorie(fruitcalorie:Fruit_Calorie){
        viewModelScope.launch(Dispatchers.IO) {
            database_Dao.deleteFromCalorie(fruitcalorie)
        }
    }

    //functions
    fun changeFruit(fruits: Fruits)
    {
        _chosenFruit.value = fruits
    }

}