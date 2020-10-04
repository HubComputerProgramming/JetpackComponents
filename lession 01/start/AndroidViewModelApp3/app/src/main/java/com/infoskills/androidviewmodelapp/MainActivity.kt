package com.infoskills.androidviewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.infoskills.androidviewmodelapp.model.User
import com.infoskills.androidviewmodelapp.utils.doGlide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.setUser(User(1,"Abhi Bhati", "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50.jpg"))

        mainViewModel._user.observe(this, {user ->
            tvUserId.text = user.uid.toString()
            tvDisplayName.text = user.displayName
            ivProfile.doGlide(user.profileImg)
        })
    }
}

