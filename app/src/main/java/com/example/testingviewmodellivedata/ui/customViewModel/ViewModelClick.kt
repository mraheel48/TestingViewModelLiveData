package com.example.testingviewmodellivedata.ui.customViewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class ViewModelClick : ViewModel() {

    fun onAdd() {
        Log.d("myModelClick", "Add Click Testing")
    }

    fun reMove() {
        Log.d("myModelClick", "Re Move Click Testing")
    }
}