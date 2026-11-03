package com.ifts4.trabajopractico2docuatrimestre2026.home.ui.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ItemRecyclerviewListUserBinding

class ListAdapter(private val recyclerViewClicks: OnRecyclerViewClicks) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var personList = emptyList<Persona>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewListUserBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding = binding)
    }

    // For
    override fun onBindViewHolder(
        holder: ListViewHolder,
        position: Int //0
    ) {
        val person = personList[position]
        holder.bind(persona =  person)
    }

    /*override fun getItemCount(): Int {
        return userList.size
    }*/

    override fun getItemCount(): Int = personList.size


    @SuppressLint("NotifyDataSetChanged")
    fun updateList(personList: List<Persona>) {
        this.personList = personList
        notifyDataSetChanged()
    }


    inner class ListViewHolder(private val binding: ItemRecyclerviewListUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(persona: Persona) {
            with(binding) {
                tvId.text = persona.id.toString()
                tvName.text = persona.name
                tvDescription.text = persona.description
                tvAge.text = persona.age.toString()
            }

            binding.root.setOnClickListener {
                recyclerViewClicks.onPersonClick(persona = persona)
            }
        }
    }
}