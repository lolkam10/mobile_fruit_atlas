package com.example.project2_atlas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.Factory.Fruit_List_Handler_Factory
import com.example.project2_atlas.ViewModel.Fruits_List_Handler


class Settings_Fragment : Fragment() {
    private lateinit var viewModel_Fruit_List: Fruits_List_Handler
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_settings_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory_list= Fruit_List_Handler_Factory((requireNotNull(this.activity).application))
        viewModel_Fruit_List= ViewModelProvider(requireActivity(), factory_list).get(Fruits_List_Handler::class.java)
        view.findViewById<Button>(R.id.Purge_Favourite_Fruit).setOnClickListener(){
            viewModel_Fruit_List.ClearDatabase()
        }
    }
}