package com.ifts4.trabajopractico2docuatrimestre2026.home.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ItemRecyclerviewListUserBinding

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewListUserBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding = binding)
    }

    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int
    ) {
        val person = personList[position]
        holder.bind(persona =  person)
    }

    /*override fun getItemCount(): Int {
        return userList.size
    }*/

    override fun getItemCount(): Int = personList.size


    inner class ListViewHolder(private val binding: ItemRecyclerviewListUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(persona: Persona) {
            binding.tvId.text = persona.id.toString()
            binding.tvName.text = persona.name
            binding.tvDescription.text = persona.description
            binding.tvAge.text = persona.age.toString()
        }
    }




    private var personList = listOf<Persona>(
        Persona(
            id = 1,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 2,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 3,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 4,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 5,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 6,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 7,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 8,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 9,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 1,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 2,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 3,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 4,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 5,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 6,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 7,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 8,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 9,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 1,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 2,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 3,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 4,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 5,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 6,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 7,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 8,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 9,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 1,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 2,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 3,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 4,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 5,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 6,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 7,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 8,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 9,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 1,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 2,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 3,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 4,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 5,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 6,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 7,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 8,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 9,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 1,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 2,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 3,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 4,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 5,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 6,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 7,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 8,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 9,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 1,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 2,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 3,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 4,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 5,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 6,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
        Persona(
            id = 7,
            name = "Pepe Mujica",
            description = "Presidente uruguayo",
            age = 99
        ),
        Persona(
            id = 8,
            name = "Michael Jackson",
            description = "Rey del pop",
            age = 56
        ),
        Persona(
            id = 9,
            name = "Leo Messi",
            description = "GOAT",
            age = 38
        ),
    )
}