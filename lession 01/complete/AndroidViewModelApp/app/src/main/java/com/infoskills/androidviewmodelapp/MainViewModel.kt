package com.infoskills.androidviewmodelapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infoskills.androidviewmodelapp.model.User

class MainViewModel(val mainRepository: MainRepository) : ViewModel(){

    val _user:MutableLiveData<User> = MutableLiveData()


    fun getUser(){
        _user.value = mainRepository.user
    }


}