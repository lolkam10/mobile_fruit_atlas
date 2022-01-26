package com.example.project2_atlas.ViewModel.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.ViewModels.Choose_Fruit_To_ListVM
import com.example.project2_atlas.ViewModel.ViewModels.Search_By_FamilyVM

class Choose_Fruit_To_List_Adapter (private val fruits: LiveData<List<Fruits>>, private val viewModel : Choose_Fruit_To_ListVM)
    : RecyclerView.Adapter<Choose_Fruit_To_List_Adapter.FruitsListHolder>(){

    inner class FruitsListHolder(private val view : View): RecyclerView.ViewHolder(view){
        val fName = view.findViewById<TextView>(R.id.onerow_fruitToList_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.onerow_fruit_to_list,parent,false)
        return FruitsListHolder(view)
    }

    override fun onBindViewHolder(holder: FruitsListHolder, position: Int) {
        holder.fName.text = fruits.value?.get(position)?.fruitName
        holder.fName.setOnClickListener {
            viewModel._chosenFruit.value= fruits.value?.get(position)
        }
    }

    override fun getItemCount(): Int {
        return fruits.value?.size?:0
    }
}