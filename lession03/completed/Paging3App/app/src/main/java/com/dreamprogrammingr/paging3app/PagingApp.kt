package com.dreamprogrammingr.paging3app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class PagingApp : Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}