package com.example.project2_atlas.ViewModel.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.ViewModels.Search_By_FamilyVM

class Search_By_Family_Adapter(private val fruits: LiveData<List<Fruit>>, private val viewModel : Search_By_FamilyVM)
    : RecyclerView.Adapter<Search_By_Family_Adapter.FruitsListHolder>(){

    inner class FruitsListHolder(private val view : View): RecyclerView.ViewHolder(view){
        val fruitID = view.findViewById<TextView>(R.id.onerow_fruitID)
        val fruitName = view.findViewById<TextView>(R.id.onerow_fruitName)
        val fruitButtonAdd = view.findViewById<Button>(R.id.onerow_fruitBut)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_fruit_row,parent,false)
        return FruitsListHolder(view)
    }

    override fun onBindViewHolder(holder: FruitsListHolder, position: Int) {
        holder.fruitID.text = fruits.value?.get(position)?.id.toString()
        holder.fruitName.text = fruits.value?.get(position)?.name
        holder.fruitButtonAdd.setOnClickListener {
            //TODO
        }
    }

    override fun getItemCount(): Int {
        return fruits.value?.size?:0
    }
}