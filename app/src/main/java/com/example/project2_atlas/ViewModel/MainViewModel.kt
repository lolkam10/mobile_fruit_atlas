package com.example.project2_atlas.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project2_atlas.Model.Fruit
import com.example.project2_atlas.Model.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {
    private val _allFruits : MutableLiveData<List<Fruit>> = MutableLiveData()
    val allFruits : LiveData<List<Fruit>>
        get() {
            return _allFruits
        }

    fun getAll()
    {
        viewModelScope.launch {
            val fruits = Repo.getAll()
            val x = 0

            if(fruits != null)
                _allFruits.value = fruits!!
        }

    }
}