package com.example.testapplicationalmasamirov.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class Factory(val app : Application) :ViewModelProvider.Factory {
override fun <T : ViewModel?> create(modelClass: Class<T>): T {
if (modelClass.isAssignableFrom(com.example.testapplicationalmasamirov.viewmodel.ViewModel ::class.java)){
    @Suppress("UNCHECKED_CAST")
    return com.example.testapplicationalmasamirov.viewmodel.ViewModel(app) as T
}
    throw IllegalArgumentException("Unable to construct viewmodel")
}
}

