package com.example.project2_atlas.ViewModel.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.project2_atlas.R
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.ViewModel.Fruits_List_Handler

class Favourites_List_Adapter(private val fruits: LiveData<List<Fruits>>, private val viewModel:Fruits_List_Handler, context: Context):RecyclerView.Adapter<Favourites_List_Adapter.Search_By_Name_Holder>() {
    inner class Search_By_Name_Holder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewID = view.findViewById<TextView>(R.id.onerow_fruitID)
        val textViewFruitName= view.findViewById<TextView>(R.id.onerow_fruitName)
        val myView = view
        val button=view.findViewById<Button>(R.id.onerow_fruitBut)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Search_By_Name_Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.one_fruit_row, parent, false)
        return Search_By_Name_Holder(view)
    }
    override fun onBindViewHolder(holder: Search_By_Name_Holder, position: Int) {
        holder.textViewID.text=fruits.value?.get(position)?.fruitID.toString()
        holder.textViewFruitName.text=fruits.value?.get(position)?.fruitName
        val bundle = Bundle()
        bundle.putString("name",fruits.value?.get(position)?.fruitName)
        holder.myView.setOnClickListener(){
            //viewModel.fruit=Fruits(0L,0L,fruits.value?.get(position)?.fruitName!!,false)
            holder.myView.findNavController().navigate(R.id.action_favourites_List_Fragment_to_fruit_Details_Fragment,bundle)
        }
        holder.button.setOnClickListener(){
            fruits.value?.get(position)?.favourite=true
            val x=fruits.value?.get(position)?.favourite!!
            viewModel.AddToFavourites(fruits.value?.get(position)?.fruitName!!)
            val z=0
        }
    }

    override fun getItemCount()=fruits.value?.size?:0


}