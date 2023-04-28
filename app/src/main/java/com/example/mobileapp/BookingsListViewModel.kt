package com.example.mobileapp
import androidx.room.Dao
import androidx.room.Query
import androidx.lifecycle.ViewModel
import com.example.mobileapp.BookingsRepository
import com.example.mobileapp.DatabaseClasses.bookings
import com.example.mobileapp.DatabaseClasses.bookingsDOA
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ZodiacListViewModel : ViewModel() {
    private val bookingsRepository = BookingsRepository.get()

    private val _bookings: MutableStateFlow<List<bookings>> = MutableStateFlow(emptyList())
    val bookings: StateFlow<List<bookings>>
        get() = _bookings.asStateFlow()


    }
}