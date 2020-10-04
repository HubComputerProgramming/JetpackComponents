package com.infoskills.androidviewmodelfactoryapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infoskills.androidviewmodelfactoryapp.model.User

class MainVM(val mainRep: MainRep) : ViewModel() {

    val _user = MutableLiveData<User>()

    fun getUser(){
        _user.value = mainRep.user
    }

}