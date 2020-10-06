package com.dreamprogrammingr.paging3app.model.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dreamprogrammingr.paging3app.model.ProductBean

@Dao
interface ProductDao{

    @Query("SELECT * FROM product ORDER BY _id DESC")
    fun getPages() : PagingSource<Int, ProductBean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product:ProductBean) : Long

}