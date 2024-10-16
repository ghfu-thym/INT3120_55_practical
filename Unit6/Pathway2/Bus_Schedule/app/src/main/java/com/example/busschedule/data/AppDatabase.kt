package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import kotlinx.coroutines.internal.synchronized


@Database(entities = arrayOf(BusSchedule::class), version = 1, exportSchema = false)
abstract class AppDatabase {
    abstract fun busScheduleDao(): BusScheduleDao
    companion object {
        @Volatile
        private var instance: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/bus_schedule.db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also {
                        instance = it
                    }
            }
        }
    }
}