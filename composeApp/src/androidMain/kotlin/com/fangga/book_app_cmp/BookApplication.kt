package com.fangga.book_app_cmp

import android.app.Application
import com.fangga.book_app_cmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // configure Koin just for android platform if we had certain modules that contains only android dependencies
        initKoin {
            androidContext(this@BookApplication)
        }
    }
}