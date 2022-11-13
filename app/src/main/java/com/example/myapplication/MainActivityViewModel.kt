package com.example.myapplication

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Repository
import com.example.myapplication.data.db.Entity
import com.example.myapplication.data.db.GithubDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var elements = MutableLiveData<List<Entity>>();
    fun getData(activity: Activity) {
        viewModelScope.launch(Dispatchers.IO) {
            val dao = GithubDatabase.Companion.create(activity.applicationContext).dao()
            val repository: Repository = Repository(dao)
            val data = repository.getdata()
            activity.runOnUiThread {
                elements.value = data
            }

        }
    }
}