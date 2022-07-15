package com.example.testingviewmodellivedata.ui.customViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testingviewmodellivedata.App
import com.example.testingviewmodellivedata.Utils
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONArray

class CategoryViewModel : ViewModel() {

    private val _resultingCategory = MutableLiveData<CategoryViewModel>()

    val resultingCategory: LiveData<CategoryViewModel>
        get() = _resultingCategory

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob)

    fun getData(){


        viewModelScope.launch {

            val jsonArrayAssets = JSONArray(Utils.loadJSONFromAsset(App.getInstance() ,"categories.json"))

            /*for (i in 0 until jsonArrayAssets.length()) {
                val dataModel = Gson().fromJson(
                    jsonArrayAssets[i].toString(),
                    CategoryViewModel::class.java
                )
                _resultingCategory.addAll(listOf(dataModel))
            }*/

        }
    }
}