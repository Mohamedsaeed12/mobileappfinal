package com.example.mobileapp

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class datepicker : AppCompatActivity() {
    lateinit var tvTime : TextView
    lateinit var timeb : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_homepage)
        tvTime = findViewById(R.id.dateTV)
        timeb = findViewById(R.id.button)

        timeb.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, hourofDay, minute ->
                tvTime.setText("$hourofDay:$minute")

            }, startHour, startMinute, false).show()


        }
    }}