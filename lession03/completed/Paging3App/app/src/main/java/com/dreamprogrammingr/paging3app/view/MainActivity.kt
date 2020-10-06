package com.dreamprogrammingr.paging3app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dreamprogrammingr.paging3app.R
import com.dreamprogrammingr.paging3app.model.ProductBean
import com.dreamprogrammingr.paging3app.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel:MainViewModel

    lateinit var productPagingAdapter : ProductPagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

//        createFakeData()
        productPagingAdapter = ProductPagingAdapter()
        rvProductList.layoutManager = LinearLayoutManager(this)
        rvProductList.adapter = productPagingAdapter

        lifecycleScope.launch {
            mainViewModel.productList.collect {
                productPagingAdapter.submitData(it)
            }
        }


    }

    fun createFakeData(){
        GlobalScope.launch {
            for (i in 0..200){
                mainViewModel.save(ProductBean(_id = i,productName = "name  $i"))
            }
        }
    }
}