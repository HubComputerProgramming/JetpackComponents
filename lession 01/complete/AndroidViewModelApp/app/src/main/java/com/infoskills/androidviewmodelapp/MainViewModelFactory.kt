package com.infoskills.androidviewmodelapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory(val mainRepository: MainRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(mainRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel classw")
    }
}