package com.dreamprogrammingr.paging3app.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.dreamprogrammingr.paging3app.model.ProductBean
import com.dreamprogrammingr.paging3app.model.db.AppDatabase


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val db = AppDatabase.getInstance(application).productDao()

    val productList = Pager(
        PagingConfig(
            pageSize = 30,
            enablePlaceholders = true,
            maxSize = 300
        )
    ) {
        db.getPages()
    }.flow

    fun save(productBean: ProductBean){
       val result = db.insert(productBean)
        Log.d("DB", "Result $result")

    }
}