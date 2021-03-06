package com.example.project2_atlas.ViewModel.Adapters

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.MainActivity
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.ViewModels.Search_By_FamilyVM

class Search_By_Family_Adapter(private val fruits: LiveData<List<Fruit>>, private val viewModel : Search_By_FamilyVM)
    : RecyclerView.Adapter<Search_By_Family_Adapter.FruitsListHolder>(){

    inner class FruitsListHolder(private val view : View): RecyclerView.ViewHolder(view){
        val fruitID = view.findViewById<TextView>(R.id.onerow_fruitID)
        val fruitName = view.findViewById<TextView>(R.id.onerow_fruitName)
        val fruitButtonAdd = view.findViewById<Button>(R.id.onerow_fruitBut)
        val myView = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_fruit_row,parent,false)
        return FruitsListHolder(view)
    }

    override fun onBindViewHolder(holder: FruitsListHolder, position: Int) {
        holder.fruitID.text = fruits.value?.get(position)?.id.toString()
        holder.fruitName.text = fruits.value?.get(position)?.name
        val bundle = Bundle()
        bundle.putString("name",fruits.value?.get(position)?.name)
        holder.myView.setOnClickListener(){
            holder.myView.findNavController().navigate(R.id.action_search_By_Family_Fragment_to_fruit_Details_Fragment,bundle)
        }
        holder.fruitButtonAdd.setOnClickListener {
            val builder = AlertDialog.Builder(it.context)
            builder.setTitle("UWAGA")
            builder.setMessage("Add "+fruits.value?.get(position)?.name+" to favourites?")
            builder.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
                viewModel.AddToFavourites(fruits.value?.get(position)?.name!!)
                Toast.makeText(it.context, fruits.value?.get(position)?.name+" added to favourites", Toast.LENGTH_LONG).show()})
            builder.show()
            //viewModel.AddToFavourites(fruits.value?.get(position)?.name!!)
        }
    }

    override fun getItemCount(): Int {
        return fruits.value?.size?:0
    }
}