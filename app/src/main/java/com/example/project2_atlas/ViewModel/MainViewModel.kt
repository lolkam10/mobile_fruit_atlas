package com.example.project2_atlas.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Model.Repo
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    //properties
    private val _allFruits : MutableLiveData<List<Fruit>> = MutableLiveData()
    val allFruits : LiveData<List<Fruit>>
        get() {
            return _allFruits
        }
    private val _oneFruit : MutableLiveData<Fruit> = MutableLiveData()
    val oneFruit : LiveData<Fruit>
        get() {
            return _oneFruit
        }
    private val _familyOfFruits : MutableLiveData<List<Fruit>> = MutableLiveData()
    val familyOfFruits : LiveData<List<Fruit>>
        get() {
            return _familyOfFruits
        }

    //functions
    fun getAll()
    {
        viewModelScope.launch {
            val fruits = Repo.getAll()
            if(fruits != null)
                _allFruits.value = fruits!!
        }

    }
    fun getFruit(x:String)
    {
        viewModelScope.launch {
            val fruit = Repo.getFruitByName(x)
            if(fruit != null)
                _oneFruit.value = fruit!!
        }
    }
    fun getFamily(x:String)
    {
        viewModelScope.launch {
            val fruit = Repo.getFruitByFamily(x)
            if(fruit != null)
                _familyOfFruits.value = fruit!!
        }
    }

}