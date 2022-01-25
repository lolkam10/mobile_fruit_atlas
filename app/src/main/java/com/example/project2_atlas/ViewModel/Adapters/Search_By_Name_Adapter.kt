package com.example.project2_atlas.ViewModel.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.project2_atlas.R
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.ViewModel.Fruits_List_Handler

class Search_By_Name_Adapter(private val fruits: LiveData<List<Fruits>>,private val viewModel:Fruits_List_Handler,context: Context):RecyclerView.Adapter<Search_By_Name_Adapter.Search_By_Name_Holder>() {
    inner class Search_By_Name_Holder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textViewID = view.findViewById<TextView>(R.id.onerow_fruitID)
        val textViewFruitName= view.findViewById<TextView>(R.id.onerow_fruitID)
        //val textViewLastName = view.findViewById<TextView>(R.id.last_name)
        val myView = view
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Search_By_Name_Holder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.one_fruit_row, parent, false)
        return Search_By_Name_Holder(view)
    }
    override fun onBindViewHolder(holder: Search_By_Name_Holder, position: Int) {
        holder.textViewID.text=fruits.value?.get(position)?.fruitID.toString()
        holder.textViewFruitName.text=fruits.value?.get(position)?.fruitName
        holder.myView.setOnClickListener(){
            viewModel.fruit=Fruits(0L,0L,fruits.value?.get(position)?.fruitName!!,false)
            holder.myView.findNavController().navigate(R.id.action_search_For_Fruit_Fragment3_to_fruit_Details_Fragment)
        }
    }

    override fun getItemCount()=fruits.value?.size?:0


}