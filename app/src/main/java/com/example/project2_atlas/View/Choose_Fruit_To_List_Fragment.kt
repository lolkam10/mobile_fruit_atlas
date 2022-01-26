package com.example.project2_atlas.View

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.Adapters.Choose_Fruit_To_List_Adapter
import com.example.project2_atlas.ViewModel.Adapters.Search_By_Family_Adapter
import com.example.project2_atlas.ViewModel.ViewModels.Choose_Fruit_To_ListVM

class Choose_Fruit_To_List_Fragment() :Fragment() {

    lateinit var vm : Choose_Fruit_To_ListVM
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(Choose_Fruit_To_ListVM::class.java)
        return inflater.inflate(R.layout.fragment_choose_fruit_to_list, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recycler list owoce
        val adapter = Choose_Fruit_To_List_Adapter(vm.allFruits,vm)
        vm.allFruits.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.fragment_chooseFruitToList_RV).let {
            it.adapter = adapter
            it.layoutManager = layoutManager
        }

        val tv = view.findViewById<TextView>(R.id.fragment_chooseFruitToList_name)
        vm.chosenFruit.observe(viewLifecycleOwner,{tv.text = vm.chosenFruit.value?.fruitName?:"nic"})

    }
}