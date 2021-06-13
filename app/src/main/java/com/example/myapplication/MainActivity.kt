package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class MainActivity : AppCompatActivity() {

    lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        navController = findNavController(R.id.fragmentContainerView)

//

//        findNavController(R.id.fragmentContainerView).setGraph(
//            R.navigation.my_nav
//        )

//        //

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as Fragment
//        val inflater = navHostFragment.findNavController()
//        val graph = layoutInflater.inflate(R.navigation.my_nav)
        val bundle = bundleOf("data" to "testing")

        findNavController(R.id.fragmentContainerView).setGraph(R.navigation.my_nav,bundle)
    }
}