package com.ifts4.trabajopractico2docuatrimestre2026.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona


@Dao
interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(persona: Persona)

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Persona>>

    @Update
    fun update(persona: Persona)


    @Delete
    fun deletePerson(persona: Persona)


    @Query("DELETE FROM person_table")
    fun deleteAll()
}