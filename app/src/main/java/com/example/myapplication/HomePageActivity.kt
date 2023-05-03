package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.braze.Braze
import com.google.android.material.bottomsheet.BottomSheetDialog

class HomePageActivity : AppCompatActivity() {
    // private val amplitude = MyCustomApplication.amplitude

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        Braze.getInstance(this).openSession(this)

        // Track a basic event
        // amplitude.track("Identified action")

        // get reference to button
        val btnPushPermission = findViewById<Button>(R.id.button_high_value_action)
        // set on-click listener
        btnPushPermission.setOnClickListener {
            Braze.getInstance(this).logCustomEvent("High Value Action Performed")
        }

        // get reference to button
        val btnLocationPermission = findViewById<Button>(R.id.button_purchase)
        // set on-click listener
        btnLocationPermission.setOnClickListener {
            Braze.getInstance(this).logCustomEvent("Purchase performed")
            val dialog = BottomSheetDialog(this)
            val view=layoutInflater.inflate(R.layout.dialog_layout,null)
            dialog.setContentView(view)
            dialog.show()
        }

    }

    override fun onStop() {
        super.onStop()
        Braze.getInstance(this).closeSession(this)
    }

}