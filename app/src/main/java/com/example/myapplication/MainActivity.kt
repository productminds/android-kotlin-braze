package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.braze.Braze
import com.example.myapplication.R.*

class MainActivity : AppCompatActivity() {

    private val amplitude = MyCustomApplication.amplitude

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        // get reference to button
        val btnLogIn = findViewById<Button>(id.loginButton)
        // set on-click listener
        btnLogIn.setOnClickListener {
            Braze.getInstance(this).openSession(this)
            // hardcoded user id
            Braze.getInstance(this).changeUser("5082e52c-e8ed-11ed-a05b-0242ac120003")
            val intent = Intent(applicationContext, HomePageActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity, "Starting Session", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        Braze.getInstance(this).closeSession(this)
    }


}