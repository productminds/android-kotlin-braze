package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

import com.braze.Braze;

import com.example.myapplication.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        // get reference to button
        val btnStartSession = findViewById<Button>(id.button_start_session)
        // set on-click listener
        btnStartSession.setOnClickListener {
            Braze.getInstance(this).openSession(this)
            Toast.makeText(this@MainActivity, "Starting Session", Toast.LENGTH_SHORT).show()
        }

        val btnEndSession = findViewById<Button>(id.button_end_session)
        // set on-click listener
        btnEndSession.setOnClickListener {
            Toast.makeText(this@MainActivity, "Ending Session", Toast.LENGTH_SHORT).show()
        }

        // get reference to button
        val btnPushPermission = findViewById<Button>(id.button_ask_push_permission)
        // set on-click listener
        btnPushPermission.setOnClickListener {
            Toast.makeText(this@MainActivity, "Asking for push permission", Toast.LENGTH_SHORT).show()
        }

        // get reference to button
        val btnLocationPermission = findViewById<Button>(id.button_ask_location_permission)
        // set on-click listener
        btnLocationPermission.setOnClickListener {
            Toast.makeText(this@MainActivity, "Asking for location permission", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        Braze.getInstance(this).closeSession(this)
    }


}