package com.example.mobileapp

import android.app.Application
import com.example.mobileapp.BookingsRepository

class BookingsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BookingsRepository.initialize(this)
    }
}