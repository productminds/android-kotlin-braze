package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.braze.Braze

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        Braze.getInstance(this).openSession(this)

        // get reference to button
        val btnPushPermission = findViewById<Button>(R.id.button_ask_push_permission)
        // set on-click listener
        btnPushPermission.setOnClickListener {
            Braze.getInstance(this).changeUser("testing");
            Toast.makeText(this@HomePageActivity, "Asking and changing for push permission", Toast.LENGTH_SHORT).show()
        }

        // get reference to button
        val btnLocationPermission = findViewById<Button>(R.id.button_ask_location_permission)
        // set on-click listener
        btnLocationPermission.setOnClickListener {
            Toast.makeText(this@HomePageActivity, "Asking for location permission", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onStop() {
        super.onStop()
        Braze.getInstance(this).closeSession(this)
    }

}