package com.example.project2_atlas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.ViewModels.Fruit_DetailsVM

class Fruit_Details_Fragment : Fragment() {

    lateinit var vm : Fruit_DetailsVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(Fruit_DetailsVM::class.java)
        val name = arguments?.getString("name")?:"Melon"
        vm.changeFruit(name)
        return inflater.inflate(R.layout.fragment_fruit__details_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.fruit.observe(viewLifecycleOwner,{
            view.findViewById<TextView>(R.id.fragment_details_id).text = vm.fruit.value?.id.toString()
            view.findViewById<TextView>(R.id.fragment_details_name).text = vm.fruit.value?.name
            view.findViewById<TextView>(R.id.fragment_details_family).text = vm.fruit.value?.family
            view.findViewById<TextView>(R.id.fragment_details_genus).text = vm.fruit.value?.genus
            view.findViewById<TextView>(R.id.fragment_details_order).text = vm.fruit.value?.order
            view.findViewById<TextView>(R.id.fragment_details_carbo).text = vm.fruit.value?.nutritions?.carbohydrates.toString()
            view.findViewById<TextView>(R.id.fragment_details_protein).text = vm.fruit.value?.nutritions?.protein.toString()
            view.findViewById<TextView>(R.id.fragment_details_fat).text = vm.fruit.value?.nutritions?.fat.toString()
            view.findViewById<TextView>(R.id.fragment_details_calories).text = vm.fruit.value?.nutritions?.calories.toString()
            view.findViewById<TextView>(R.id.fragment_details_sugar).text = vm.fruit.value?.nutritions?.sugar.toString()
        })

    }

}