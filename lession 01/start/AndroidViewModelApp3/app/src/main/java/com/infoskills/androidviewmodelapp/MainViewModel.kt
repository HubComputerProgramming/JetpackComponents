package com.infoskills.androidviewmodelapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.infoskills.androidviewmodelapp.model.User

class MainViewModel : ViewModel() {

    val _user = MutableLiveData<User>()


    fun setUser(user:User){
       _user.value = user
    }
}