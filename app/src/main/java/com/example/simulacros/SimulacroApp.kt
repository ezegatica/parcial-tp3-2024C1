package com.example.simulacros

import android.app.Application
import com.example.simulacros.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SimulacroApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Config.apiKey = ""
        Config.baseUrl = resources.getString(R.string.mock_api_base_url)
    }
}