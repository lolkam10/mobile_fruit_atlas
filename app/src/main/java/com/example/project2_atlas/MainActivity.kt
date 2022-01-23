package com.example.project2_atlas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.project2_atlas.ViewModel.MainViewModel
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var vm :MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.allFruits.observe(this, Observer { findViewById<TextView>(R.id.mainView_tv).text = it.toString() })

        vm.getAll()
    }

}