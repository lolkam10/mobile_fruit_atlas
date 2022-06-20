package com.example.project2_atlas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.Adapters.Calories_List_Adapter
import com.example.project2_atlas.ViewModel.Adapters.Choose_Fruit_To_List_Adapter
import com.example.project2_atlas.ViewModel.ViewModels.Calories_ListVM
import com.example.project2_atlas.ViewModel.ViewModels.Choose_Fruit_To_ListVM


class Calories_Calculator_Fragment : Fragment() {
    lateinit var vm : Choose_Fruit_To_ListVM
    lateinit var vm2: Calories_ListVM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(Choose_Fruit_To_ListVM::class.java)
        vm2=ViewModelProvider(this).get(Calories_ListVM::class.java)
        return inflater.inflate(R.layout.fragment_calories_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val adapter = Choose_Fruit_To_List_Adapter(vm.allFruits,vm)
        val adapter=Calories_List_Adapter(vm2.allFruitsCalorie,vm2)
        vm2.allFruitsCalorie.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.fragment_caloriesCalc_RV).let {
            it.adapter = adapter
            it.layoutManager = layoutManager
        }
        view.findViewById<Button>(R.id.fragment_caloriesCalc_but_add).setOnClickListener{
            it.findNavController().navigate(R.id.action_calories_Calculator_Fragment_to_choose_Fruit_To_List_Fragment)
        }
    }
}