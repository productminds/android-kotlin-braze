package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.braze.Braze
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