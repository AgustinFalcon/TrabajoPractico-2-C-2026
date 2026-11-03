package com.ifts4.trabajopractico2docuatrimestre2026.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ifts4.trabajopractico2docuatrimestre2026.TpDesaMobileApp
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona

@Database(entities = [Persona::class], version = 2, exportSchema = false)
abstract class PersonDB : RoomDatabase() {

    abstract fun personaDao(): PersonDAO


    companion object {
        private var INSTANCE: PersonDB? = null

        // Singleton
        fun getInstance(): PersonDB {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    TpDesaMobileApp.instance.applicationContext,
                    PersonDB::class.java,
                    Constants.DB_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}