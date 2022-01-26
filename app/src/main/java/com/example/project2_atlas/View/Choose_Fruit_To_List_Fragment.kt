package com.example.project2_atlas.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.Entities.Fruit_Calorie
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.Adapters.Calories_List_Adapter
import com.example.project2_atlas.ViewModel.Adapters.Choose_Fruit_To_List_Adapter
import com.example.project2_atlas.ViewModel.Adapters.Search_By_Family_Adapter
import com.example.project2_atlas.ViewModel.ViewModels.Calories_ListVM
import com.example.project2_atlas.ViewModel.ViewModels.Choose_Fruit_To_ListVM
import com.example.project2_atlas.ViewModel.ViewModels.Fruit_DetailsVM
import kotlinx.coroutines.delay

class Choose_Fruit_To_List_Fragment() :Fragment() {

    lateinit var vm : Choose_Fruit_To_ListVM
    lateinit var vm2:Calories_ListVM
    lateinit var vm3 : Fruit_DetailsVM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(Choose_Fruit_To_ListVM::class.java)
        vm2=ViewModelProvider(this).get(Calories_ListVM::class.java)
        vm3= ViewModelProvider(this).get(Fruit_DetailsVM::class.java)
        //val name = arguments?.getString("name")?:"Melon"

        return inflater.inflate(R.layout.fragment_choose_fruit_to_list, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler list owoce
        val adapter = Choose_Fruit_To_List_Adapter(vm.allFruits,vm)
        val adapter2=Calories_List_Adapter(vm2.allFruitsCalorie,vm2)
        vm.allFruits.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.fragment_chooseFruitToList_RV).let {
            it.adapter = adapter
            it.layoutManager = layoutManager
        }

        val tv = view.findViewById<TextView>(R.id.fragment_chooseFruitToList_name)
        vm.chosenFruit.observe(viewLifecycleOwner,{tv.text = vm.chosenFruit.value?.fruitName?:"nic"})
        vm3.changeFruit(vm.chosenFruit.value?.fruitName?:"Melon")
        view.findViewById<Button>(R.id.fragment_chooseFruitToList_but).setOnClickListener(){
            vm3.changeFruit(vm.chosenFruit.value?.fruitName?:"Melon")
            var z=vm3.fruit.value?.nutritions?.calories.toString().toDouble()
            z=z*0.01*view.findViewById<EditText>(R.id.fragment_chooseFruitToList_value).text.toString().toDouble()
            var q=tv.text
            var x=Fruit_Calorie(0L,tv.text.toString(),z,view.findViewById<EditText>(R.id.fragment_chooseFruitToList_value).text.toString().toDouble())
            vm2.addToCalorieList(x)

        }

    }
}