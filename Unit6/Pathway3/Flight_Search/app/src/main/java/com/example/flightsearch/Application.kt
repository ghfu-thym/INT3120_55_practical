package com.example.flightsearch

import android.app.Application

class Application: Application() {

    lateinit var container: AppContainer

    lateinit var userPreferences: UserPreferences

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
        userPreferences = UserPreferences(dataStore)
    }
}