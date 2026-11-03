package com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "person_table")
data class Persona(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "nombre")
    val name: String,

    @ColumnInfo(name = "descripcion")
    val description: String,

    @ColumnInfo(name = "edad")
    val age: Int,

    val colorFavorito: String = "ROJO"
) : java.io.Serializable
