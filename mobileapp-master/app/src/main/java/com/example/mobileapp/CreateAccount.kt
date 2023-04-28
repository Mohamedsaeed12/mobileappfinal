package com.example.mobileapp

import DatabaseHelper
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity



    class CreateAccount : AppCompatActivity() {
         lateinit var usercreate: EditText
         lateinit var passwordcreate: EditText
        private lateinit var db: SQLiteDatabase

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.create_password_user)

            // Create an instance of DatabaseHelper
            val dbHelper = DatabaseHelper(this)
            // Get a writable database instance
            db = dbHelper.writableDatabase

            usercreate = findViewById(R.id.create_user)
            passwordcreate = findViewById(R.id.create_pass)
            val button_sendto_login = findViewById<Button>(R.id.button2)

            button_sendto_login.setOnClickListener{
                // Insert data into the database
                val values = ContentValues().apply {
                    put("userlogin", usercreate.text.toString())
                    put("userPass", passwordcreate.text.toString())
                }
                db.insert("users", null, values)

                // Navigate to MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        override fun onDestroy() {
            db.close()
            super.onDestroy()
        }
    }