package com.example.project2_atlas.ViewModel.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Model.Database_Helper
import com.example.project2_atlas.Model.FruitDatabase_DAO
import com.example.project2_atlas.Model.Repo
import kotlinx.coroutines.launch

class Fruit_DetailsVM (application: Application) : AndroidViewModel(application) {
    private val myDAO : FruitDatabase_DAO = Database_Helper.getInstance(application).databaseDao

    private val _fruit : MutableLiveData<Fruit> = MutableLiveData()
    val fruit : LiveData<Fruit>
        get() {
            return _fruit
        }

    fun changeFruit(name:String){
        viewModelScope.launch {
            val newFruit = Repo.getFruitByName(name)
            if(newFruit != null)
                _fruit.value = newFruit!!
        }
    }
}