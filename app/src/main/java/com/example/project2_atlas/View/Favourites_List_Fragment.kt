package com.example.project2_atlas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.Adapters.Favourites_List_Adapter
import com.example.project2_atlas.ViewModel.Adapters.Search_By_Name_Adapter
import com.example.project2_atlas.ViewModel.Factory.Fruit_List_Handler_Factory
import com.example.project2_atlas.ViewModel.Fruits_List_Handler

class Favourites_List_Fragment : Fragment() {
    private lateinit var viewModel_Fruit_List: Fruits_List_Handler
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favourites__list_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        val factory_list= Fruit_List_Handler_Factory((requireNotNull(this.activity).application))
        viewModel_Fruit_List= ViewModelProvider(requireActivity(), factory_list).get(Fruits_List_Handler::class.java)
        viewModel_Fruit_List.Favouritefruits=viewModel_Fruit_List.GetFavourites()
        val fruitListAdapter=
            Favourites_List_Adapter(viewModel_Fruit_List.Favouritefruits,viewModel_Fruit_List,this.requireContext())
        viewModel_Fruit_List.Favouritefruits.observe(viewLifecycleOwner,{fruitListAdapter.notifyDataSetChanged()})
        val layoutManager= LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.fragment_favourites_RV).let{
            it.adapter=fruitListAdapter
            it.layoutManager=layoutManager
        }
    }

}