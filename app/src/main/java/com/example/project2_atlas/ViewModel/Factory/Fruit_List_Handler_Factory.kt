package com.example.project2_atlas.ViewModel.Factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project2_atlas.ViewModel.Fruits_List_Handler
import java.lang.IllegalArgumentException

class Fruit_List_Handler_Factory(private val application: Application): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(Fruits_List_Handler::class.java)){
            return Fruits_List_Handler(application) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
