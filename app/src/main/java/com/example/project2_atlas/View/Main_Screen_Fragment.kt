package com.example.project2_atlas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.project2_atlas.R

class Main_Screen_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_main__screen_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //buttony
        view.findViewById<Button>(R.id.fragment_main_bt_findByName).setOnClickListener{
            it.findNavController().navigate(R.id.action_main_Screen_Fragment2_to_search_For_Fruit_Fragment3)
        }
        view.findViewById<Button>(R.id.fragment_main_bt_findByFam).setOnClickListener{
            it.findNavController().navigate(R.id.action_main_Screen_Fragment2_to_search_By_Family_Fragment)
        }
        view.findViewById<Button>(R.id.fragment_main_bt_myFav).setOnClickListener{
            it.findNavController().navigate(R.id.action_main_Screen_Fragment2_to_favourites_List_Fragment)
        }
        view.findViewById<Button>(R.id.fragment_main_bt_calc).setOnClickListener{
            it.findNavController().navigate(R.id.action_main_Screen_Fragment2_to_calories_Calculator_Fragment)
        }
        view.findViewById<Button>(R.id.fragment_main_bt_settings).setOnClickListener{
            it.findNavController().navigate(R.id.action_main_Screen_Fragment2_to_settings_Fragment)
        }
    }
}