package com.infoskills.androidviewmodelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.infoskills.androidviewmodelapp.model.User
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainRepository = MainRepository(User(1,"Sonu Kumar", "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50.jpg"))
        val viewModelFactory = MainViewModelFactory(mainRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(MainViewModel::class.java)
        viewModel.getUser()

        viewModel._user.observe(this, { user ->
            tvUserId.text = user.uid.toString()
            userName.text = user.displayName
            ivProfileImage.doGlide(user.profileUrl)
        })

    }
}

private fun ImageView.doGlide(profileUrl: String) {
    Glide.with(this)
            .load(profileUrl)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(this)
}
