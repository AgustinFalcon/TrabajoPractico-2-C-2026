package com.ifts4.trabajopractico2docuatrimestre2026.home.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ifts4.trabajopractico2docuatrimestre2026.R
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.FragmentAddBinding
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.PersonViewModel
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona


class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding

    private val viewModel by viewModels<PersonViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnAddUser.setOnClickListener {
            validateData()
        }
    }

    private fun validateData() {
        val username = binding.etName.text.toString()
        val lastname = binding.etLastName.text.toString()
        val age = binding.etAge.text.toString()

        if (username.isNotBlank() && lastname.isNotBlank() && age.isNotBlank()) {

            val persona = Persona(id = 0, name = username, description = lastname, age = age.toInt())
            viewModel.createPerson(persona = persona)
            findNavController().navigate(R.id.action_addFragment_to_listFragment)

        } else {
            Toast.makeText(requireContext(), "Datos Invalidos", Toast.LENGTH_SHORT).show()
        }
    }
}