package com.ifts4.trabajopractico2docuatrimestre2026.home.ui.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ifts4.trabajopractico2docuatrimestre2026.R
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.FragmentUpdateBinding
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.PersonViewModel
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona


class UpdateFragment : Fragment() {

    private val viewModel by viewModels<PersonViewModel>()

   private lateinit var binding: FragmentUpdateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val person = arguments?.getSerializable("persona") as Persona

        binding.etName.setText(person.name)
        binding.etLastName.setText(person.description)
        binding.etAge.setText(person.age.toString())

        binding.btnUpdateUser.setOnClickListener {
            validateData(person)
        }

        binding.btndeleteUser.setOnClickListener {
            viewModel.deletePerson(persona = person)
            goToListFragment()
        }
    }

    private fun validateData(persona: Persona) {
        val username = binding.etName.text.toString()
        val lastname = binding.etLastName.text.toString()
        val age = binding.etAge.text.toString()

        if (username.isNotBlank() && lastname.isNotBlank() && age.isNotBlank()) {

            val personCopy = persona.copy(name = username, description = lastname, age = age.toInt())
            viewModel.updatePerson(persona = personCopy)
            goToListFragment()

        } else {
            Toast.makeText(requireContext(), "Complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToListFragment() {
        findNavController().navigate(R.id.action_updateFragment_to_listFragment)
    }
}