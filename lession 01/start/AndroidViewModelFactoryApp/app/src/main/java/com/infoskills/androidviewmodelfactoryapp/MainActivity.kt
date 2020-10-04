package com.infoskills.androidviewmodelfactoryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.infoskills.androidviewmodelfactoryapp.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var user : User
    lateinit var mainRep: MainRep
    lateinit var viewModelFactory: MainViewModelFactory
    lateinit var mainVM: MainVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        user = User("1","Abhi", "")
        mainRep = MainRep(user)
        viewModelFactory = MainViewModelFactory(mainRep)
        mainVM = ViewModelProvider(this, viewModelFactory).get(MainVM::class.java)

        mainVM.getUser()

        mainVM._user.observe(this, Observer {
            val sb = StringBuilder()
            sb.append(it.uid)
            sb.append("\n")
            sb.append(it.displayName)
            tvUser.text = sb.toString()
        })

    }
}