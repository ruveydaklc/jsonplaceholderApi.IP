package com.example.internshipproject.ui.base

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.internshipproject.R
import com.example.internshipproject.databinding.ActivityMainBinding
import com.example.internshipproject.databinding.TabLayoutBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var navHostFragment : NavHostFragment
    private lateinit var tab:TabLayoutBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment


        //adding tabs
        binding.tabLayout.addTab(binding.tabLayout.newTab())
        binding.tabLayout.addTab(binding.tabLayout.newTab())

        createTab()
        tabListener()
    }

    @SuppressLint("SetTextI18n")
    fun createTab(){
        tab= TabLayoutBinding.inflate(layoutInflater)

        tab.tvTitleTab.text="Users"
        binding.tabLayout.getTabAt(0)!!.customView = tab.root

        tab = TabLayoutBinding.inflate(layoutInflater)
        tab.tvTitleTab.text="Photos"
        binding.tabLayout.getTabAt(1)!!.customView = tab.root
    }

    fun chooseTab(index:Int){
        when (index)
        {
            0 -> {
                Navigation.findNavController(this@MainActivity, R.id.fragmentContainerView).navigate(R.id.userFragment)
            }
            1 -> {
                Navigation.findNavController(this@MainActivity, R.id.fragmentContainerView).navigate(R.id.postsFragment)
            }
        }
    }

    private fun tabListener(){
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                chooseTab(tab!!.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            override fun onTabReselected(tab: TabLayout.Tab?) {
                chooseTab(0)
            }
        })
    }


}

