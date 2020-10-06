package com.dreamprogrammingr.paging3app.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dreamprogrammingr.paging3app.model.ProductBean

@Database(entities = [ProductBean::class],version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context:Context) : AppDatabase =
            INSTANCE?: synchronized(this) {
                INSTANCE ?:buildDatabase(context)
            }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "product.db")
                .build()

    }
}