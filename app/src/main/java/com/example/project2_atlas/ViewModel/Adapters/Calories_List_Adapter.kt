package com.example.project2_atlas.ViewModel.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.Entities.Fruit
import com.example.project2_atlas.Entities.Fruit_Calorie
import com.example.project2_atlas.Entities.Fruits
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.ViewModels.Calories_ListVM
import com.example.project2_atlas.ViewModel.ViewModels.Choose_Fruit_To_ListVM
import com.example.project2_atlas.ViewModel.ViewModels.Search_By_FamilyVM

class Calories_List_Adapter (private val fruits: LiveData<List<Fruit_Calorie>>, private val viewModel : Calories_ListVM)
    : RecyclerView.Adapter<Calories_List_Adapter.FruitsListHolder>(){

    inner class FruitsListHolder(private val view : View): RecyclerView.ViewHolder(view){
        val fName = view.findViewById<TextView>(R.id.CalorieListName)
        val CalorieCount=view.findViewById<TextView>(R.id.TotalCalorieCount)
        val veight=view.findViewById<TextView>(R.id.TotalWeight)
        val checkbox=view.findViewById<CheckBox>(R.id.RemoveCalorieListCheckBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_calorie_list_row,parent,false)
        return FruitsListHolder(view)
    }

    override fun onBindViewHolder(holder: FruitsListHolder, position: Int) {
        holder.fName.text = fruits.value?.get(position)?.fruitName
        holder.CalorieCount.text=0.0.toString()
        holder.veight.text=fruits.value?.get(position)?.mass.toString()
      //  holder.fName.setOnClickListener {
            //viewModel._chosenFruit.value= fruits.value?.get(position)
      //  }
        /*
        holder.checkbox.setOnCheckedChangeListener   {buttonView, isChecked ->
            //Add  to temp list of selected
            if (isChecked) {
                viewModel..add(fruits.value?.get(position)?.fruitID!!)
            } else {
                var ind =
                    viewModel..indexOf(fruits.value?.get(position)?.fruitID!!)
                viewModel..removeAt(ind)
            }
       }
        */
    }

    override fun getItemCount(): Int {
        return fruits.value?.size?:0
    }
}