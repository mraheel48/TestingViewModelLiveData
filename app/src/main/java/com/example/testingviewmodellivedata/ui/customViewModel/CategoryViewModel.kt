package com.example.testingviewmodellivedata.ui.customViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testingviewmodellivedata.App
import com.example.testingviewmodellivedata.Utils
import com.example.testingviewmodellivedata.dataModel.Category
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.json.JSONArray

class CategoryViewModel : ViewModel() {

    private var readData: MutableLiveData<Category>? = null

    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(viewModelJob)

    fun getReadDataModel(): MutableLiveData<Category>? {
        if (readData == null) {
            readData = MutableLiveData<Category>()
            getData()
        }
        return readData
    }

     private fun getData() {

         viewModelScope.launch {

             val jsonArrayAssets =
                 JSONArray(Utils.loadJSONFromAsset(App.getInstance(), "categories.json"))

             for (i in 0 until jsonArrayAssets.length()) {
                 val dataModel = Gson().fromJson(
                     jsonArrayAssets[i].toString(),
                     Category::class.java
                 )

                 if (dataModel != null) {
                     readData?.postValue(dataModel)
                 } else {
                     readData?.postValue(null)
                 }
             }


         }
     }
}