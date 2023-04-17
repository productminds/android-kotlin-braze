package com.example.myapplication

import android.app.Application
import com.braze.BrazeActivityLifecycleCallbackListener

class MyCustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(BrazeActivityLifecycleCallbackListener(
            sessionHandlingEnabled = false,
            registerInAppMessageManager = true,
        ))
    }
}