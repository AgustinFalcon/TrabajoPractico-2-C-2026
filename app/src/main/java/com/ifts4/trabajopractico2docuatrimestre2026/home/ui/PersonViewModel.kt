package com.ifts4.trabajopractico2docuatrimestre2026.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona

class PersonViewModel : ViewModel() {

    val repository = PersonRepository()

    val readAllData: LiveData<List<Persona>> = repository.readAllData

    fun createPerson(persona: Persona) {
        // view -> viewmodel -> repository -> model
        repository.createPerson(persona = persona)
    }

    fun updatePerson(persona: Persona) {
        repository.updatePerson(persona = persona)
    }

    fun deletePerson(persona: Persona) {
        repository.deletePerson(persona = persona)
    }
}