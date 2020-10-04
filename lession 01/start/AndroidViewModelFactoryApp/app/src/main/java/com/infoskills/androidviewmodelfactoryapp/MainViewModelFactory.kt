package com.infoskills.androidviewmodelfactoryapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(val mainRep: MainRep) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainVM::class.java)){
            return MainVM(mainRep) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}