package com.example.mobileapp.DatabaseClasses

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [users::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookingDOA(): bookingsDOA
}