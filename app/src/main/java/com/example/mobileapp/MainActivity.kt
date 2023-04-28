package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var usercreate:EditText
    lateinit var passwordcreate:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        usercreate = findViewById(R.id.editTextTextPersonName) //user for creating password
        passwordcreate= findViewById(R.id.editTextTextPersonName2) //password in create

        val buttonclick2=findViewById<Button>(R.id.login)
        val buttonclick=findViewById<Button>(R.id.button_CreateAccount)

        buttonclick.setOnClickListener{
            val intent = Intent (this,CreateAccount::class.java).apply {
                // putExtra("data1",usercreate.text.toString())
                // putExtra("data2",passwordcreate.text.toString())
            }
            startActivity(intent)

        }


        buttonclick2.setOnClickListener {
            val i = Intent (this,LoginHomepage::class.java).apply {
                // putExtra("data1",usercreate.text.toString())
                // putExtra("data2",passwordcreate.text.toString())
            }
            startActivity(i)

        }
    }}