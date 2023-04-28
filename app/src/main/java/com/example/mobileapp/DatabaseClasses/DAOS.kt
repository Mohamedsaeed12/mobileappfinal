package com.example.mobileapp.DatabaseClasses

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.sql.Time
import java.util.*

@Dao
interface bookingsDOA {
    // Insert a new booking
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBooking(roomId: UUID, date: Date, startTime: Time, endTime: Time)

    // Check if there are any existing bookings for a specific room and time
    @Query("SELECT COUNT(*) FROM bookings WHERE roomID = :roomId AND apptdate = :date AND ((apptStartTime >= :startTime AND apptStartTime < :endTime) OR (apptendtime > :startTime AND apptendtime <= :endTime))")
    fun countBookingsForRoomAndTime(roomId: UUID, date: Date, startTime: Time, endTime: Time): Int

    // Get bookings between two times for a specific date
    @Query("SELECT * FROM bookings WHERE apptdate = :date AND apptStartTime >= :startTime AND apptendtime <= :endTime")
    fun getBookingsByTimeRange(date: Date, startTime: Time, endTime: Time): List<bookings>
}