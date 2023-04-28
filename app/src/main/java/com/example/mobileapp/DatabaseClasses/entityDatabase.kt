package com.example.mobileapp.DatabaseClasses

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Time
import java.util.Date
import java.util.UUID

@Entity(tableName = "users")
data class users(
    @PrimaryKey (autoGenerate = true) val UserID: UUID,
    val name: String,
    val userlogin: String,
    val userPass: String
)
@Entity(tableName = "room")
data class room(
    @PrimaryKey (autoGenerate = true)  val roomID: UUID,
    val roomName: String
)
@Entity(tableName = "bookings", foreignKeys = [
    ForeignKey(entity = users::class, parentColumns = ["UserID"], childColumns = ["userid"], onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = room::class, parentColumns = ["roomID"], childColumns = ["roomID"], onDelete = ForeignKey.CASCADE)
])
data class bookings(
    @PrimaryKey (autoGenerate = true)  val bookingID: UUID,
    val userid: UUID?,
    val roomID: UUID?,
    val apptdate: Date?,
    val apptStartTime: Time?,
    val apptendtime: Time?
)