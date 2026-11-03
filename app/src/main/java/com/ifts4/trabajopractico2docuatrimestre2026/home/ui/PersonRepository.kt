package com.ifts4.trabajopractico2docuatrimestre2026.home.ui

import androidx.lifecycle.LiveData
import com.ifts4.trabajopractico2docuatrimestre2026.data.db.PersonDB
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona


class PersonRepository() { // inyeccion de dependencias

    private val personDao = PersonDB.getInstance().personaDao()

    val readAllData: LiveData<List<Persona>> = personDao.readAllData()


    fun createPerson(persona: Persona) {
        personDao.insert(persona = persona)
    }

    fun updatePerson(persona: Persona) {
        personDao.update(persona = persona)
    }

    fun deletePerson(persona: Persona) {
        personDao.deletePerson(persona = persona)
    }
}