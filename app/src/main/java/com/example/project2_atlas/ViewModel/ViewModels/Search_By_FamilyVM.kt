package com.example.project2_atlas.ViewModel.ViewModels

import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Model.Database_Helper
import com.example.project2_atlas.Model.Repo
import com.example.project2_atlas.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Search_By_FamilyVM (application: Application) : AndroidViewModel(application) {
    private val database_Dao = Database_Helper.getInstance(application).databaseDao
    //properties
    private val _familyOfFruits : MutableLiveData<List<Fruit>> = MutableLiveData()
    val familyOfFruits : LiveData<List<Fruit>>
        get() {
            return _familyOfFruits
        }


    //functions
    fun getFamily(x:String)
    {
        viewModelScope.launch {
            val fruits = Repo.getFruitByFamily(x)
            if(fruits != null)
                _familyOfFruits.value = fruits!!
        }
    }
    fun AddToFavourites(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            database_Dao.addToFavourites(name)
        }
    }
}