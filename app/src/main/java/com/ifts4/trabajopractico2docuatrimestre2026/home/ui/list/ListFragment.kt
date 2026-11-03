package com.ifts4.trabajopractico2docuatrimestre2026.home.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifts4.trabajopractico2docuatrimestre2026.R
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.FragmentListBinding
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.PersonViewModel
import com.ifts4.trabajopractico2docuatrimestre2026.home.ui.model.Persona


class ListFragment : Fragment(), OnRecyclerViewClicks {

    private val viewModel by viewModels<PersonViewModel>()

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ListAdapter(this)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewList.layoutManager = layoutManager
        binding.recyclerViewList.adapter = adapter

        val divider = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.recyclerViewList.addItemDecoration(divider)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        viewModel.readAllData.observe(viewLifecycleOwner) { personas ->
            adapter.updateList(personList = personas)
        }
    }

    override fun onPersonClick(persona: Persona) {
        Toast.makeText(requireContext(), "Hola ${persona.name}", Toast.LENGTH_SHORT).show()
        val bundle = Bundle()
        bundle.putSerializable("persona", persona)
        findNavController().navigate(R.id.action_listFragment_to_updateFragment, bundle)
    }

}