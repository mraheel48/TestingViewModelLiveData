package com.example.testingviewmodellivedata.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import com.example.testingviewmodellivedata.databinding.ActivityMainBinding
import com.example.testingviewmodellivedata.ui.customViewModel.ViewModelClick
import com.example.testingviewmodellivedata.ui.base.BaseActivity
import com.example.testingviewmodellivedata.ui.customViewModel.CategoryViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val model = ViewModelProvider(this)[ViewModelClick::class.java]
        binding.viewmodel = model

        val categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        categoryViewModel.resultingCategory.observe(this){

        }
    }

    override fun createViewBinding(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}