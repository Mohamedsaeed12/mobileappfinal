package com.example.mobileapp
import android.content.Context
import androidx.room.Room
import com.example.mobileapp.DatabaseClasses.AppDatabase
import com.example.mobileapp.DatabaseClasses.bookings

import kotlinx.coroutines.flow.Flow
import java.sql.Time
import java.util.*

private const val DATABASE_NAME = "AndroidFinalProject"

class BookingsRepository private constructor(context: Context) {
    private val database: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        DATABASE_NAME
    )
        .createFromAsset(DATABASE_NAME)
        .build()
    suspend fun insertBooking(roomId: UUID, date: Date, startTime: Time, endTime: Time): List<bookings> = database.bookingDOA().insertBooking(roomId, date, startTime, endTime)
    suspend fun countBookingsForRoomAndTime(roomId: UUID, date: Date, startTime: Time, endTime: Time): bookings = database.bookingDOA().countBookingsForRoomAndTime(roomId, date, startTime, endTime)
    suspend fun getBookingsByTimeRange(date: Date, startTime: Time, endTime: Time): bookings = database.bookingDOA().getBookingsByTimeRange(date, startTime, endTime)

    companion object {
        private var INSTANCE: BookingsRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = BookingsRepository(context)
            }
        }
        fun get(): BookingsRepository {
            return INSTANCE ?:
            throw IllegalStateException("BookingsRepository must be initialized")
        }
    }
}