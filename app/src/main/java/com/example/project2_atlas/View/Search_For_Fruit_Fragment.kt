package com.example.project2_atlas.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2_atlas.R
import com.example.project2_atlas.ViewModel.Adapters.Search_By_Name_Adapter
import com.example.project2_atlas.ViewModel.Fruits_List_Handler
import com.example.project2_atlas.ViewModel.Factory.Fruit_List_Handler_Factory
import android.text.Editable

import android.text.TextWatcher
import android.widget.Button
import androidx.navigation.findNavController


class Search_For_Fruit_Fragment : Fragment() {
    private lateinit var viewModel_Fruit_List:Fruits_List_Handler
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_search__for__fruit_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory_list=Fruit_List_Handler_Factory((requireNotNull(this.activity).application))
        viewModel_Fruit_List=ViewModelProvider(requireActivity(), factory_list).get(Fruits_List_Handler::class.java)
        val fruitListAdapter=Search_By_Name_Adapter(viewModel_Fruit_List.fruits,viewModel_Fruit_List,this.requireContext())

/*
        view.findViewById<EditText>(R.id.fragment_searchByName_editText).addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {viewModel_Fruit_List.fruits=viewModel_Fruit_List.Search(view.findViewById<EditText>(R.id.fragment_searchByName_editText).text.toString()
            )
                fruitListAdapter.notifyDataSetChanged()
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                //viewModel_Fruit_List.fruits=viewModel_Fruit_List.Search(view.findViewById<EditText>(R.id.fragment_searchByName_editText).text.toString())
                //viewModel_Fruit_List.fruits.observe(viewLifecycleOwner,{fruitListAdapter.notifyDataSetChanged()})
            }
        })

*/
        viewModel_Fruit_List.fruits.observe(viewLifecycleOwner,{fruitListAdapter.notifyDataSetChanged()})
        val layoutManager= LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.fragment_searchByName_RV).let{
            it.adapter=fruitListAdapter
            it.layoutManager=layoutManager
        }
        view.findViewById<Button>(R.id.fragment_searchByName_but).setOnClickListener{

            viewModel_Fruit_List.fruits=viewModel_Fruit_List.Search(view.findViewById<EditText>(R.id.fragment_searchByName_editText).text.toString())
            it.findNavController().navigate(R.id.Refresh_fruit_Search)

        }
        //var field=view.findViewById<EditText>(R.id.fragment_searchByName_editText)

        //var TextField=(EditText)findViewById(R.id.fragment_searchByName_editText);
       // view.findViewById<EditText>(R.id.fragment_searchByName_editText).addTextChangedListener({
      //  @Override

      //  });
    }
}