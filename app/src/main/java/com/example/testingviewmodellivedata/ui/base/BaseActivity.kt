package com.example.testingviewmodellivedata.ui.base

import androidx.viewbinding.ViewBinding
import androidx.appcompat.app.AppCompatActivity
import android.view.LayoutInflater
import android.os.Bundle

abstract class BaseActivity<BINDING : ViewBinding> : AppCompatActivity() {

    lateinit var binding: BINDING

    protected abstract fun createViewBinding(layoutInflater: LayoutInflater): BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = createViewBinding(LayoutInflater.from(this))
        setContentView(binding.root)
    }
}