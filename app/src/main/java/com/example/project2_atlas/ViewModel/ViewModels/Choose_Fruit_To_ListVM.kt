package com.example.project2_atlas.ViewModel.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.Model.Database_Helper
import com.example.project2_atlas.Model.Repo
import kotlinx.coroutines.launch

class Choose_Fruit_To_ListVM (application: Application) : AndroidViewModel(application) {
    private val database_Dao = Database_Helper.getInstance(application).databaseDao
    //properties
    val allFruits : LiveData<List<Fruits>> = database_Dao.getAllFruitsFromDatabase()
    val _chosenFruit : MutableLiveData<Fruits> = MutableLiveData()
    val chosenFruit : LiveData<Fruits>
        get() {
            return _chosenFruit
        }

    //functions
    fun changeFruit(fruits: Fruits)
    {
        _chosenFruit.value = fruits
    }
}