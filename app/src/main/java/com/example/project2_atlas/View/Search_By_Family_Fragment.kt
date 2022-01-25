package com.example.project2_atlas.View

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.Adapters.Search_By_Family_Adapter
import com.example.project2_atlas.ViewModel.ViewModels.Search_By_FamilyVM


class Search_By_Family_Fragment : Fragment(), AdapterView.OnItemSelectedListener {

    //lateinit var spinner: Spinner
    lateinit var vm: Search_By_FamilyVM
    //lateinit var adapter: Search_By_Family_Adapter
    //lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(Search_By_FamilyVM::class.java)

        return inflater.inflate(R.layout.fragment_search__by__family_, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinner = view.findViewById<Spinner>(R.id.fragment_searchByFamily_spin)
        vm.getFamily(spinner.selectedItem.toString())

        //recycler list owoce
        val adapter = Search_By_Family_Adapter(vm.familyOfFruits,vm)
        vm.familyOfFruits.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.fragment_searchByFamily_RV).let {
            it.adapter = adapter
            it.layoutManager = layoutManager
        }


    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        vm.getFamily(spinner.selectedItem.toString())
//        vm.familyOfFruits.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}