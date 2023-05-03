package com.example.myapplication

import android.app.Application
import android.util.Log
import com.braze.BrazeActivityLifecycleCallbackListener
import com.amplitude.android.Amplitude
import com.amplitude.android.Configuration


class MyCustomApplication : Application() {

    companion object {
        lateinit var amplitude: Amplitude
        const val AMPLITUDE_API_KEY = "cad5560026764c5a552b351bf45df460"
    }


    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(BrazeActivityLifecycleCallbackListener(
            sessionHandlingEnabled = false,
            registerInAppMessageManager = true,
        ))

        // init instance
        amplitude = Amplitude(
            Configuration(
                apiKey = AMPLITUDE_API_KEY,
                context = applicationContext
            )
        )
    }
}