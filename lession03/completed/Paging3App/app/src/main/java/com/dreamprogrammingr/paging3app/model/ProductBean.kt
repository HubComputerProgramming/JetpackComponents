package com.dreamprogrammingr.paging3app.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
class ProductBean (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val _id:Int,
    @ColumnInfo(name = "product")
    val productName:String
)