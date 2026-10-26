package com.ifts4.trabajopractico2docuatrimestre2026.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifts4.trabajopractico2docuatrimestre2026.R
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.FragmentListBinding


class ListFragment : Fragment() {
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

        val adapter = ListAdapter()
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewList.layoutManager = layoutManager
        binding.recyclerViewList.adapter = adapter

        val divider = DividerItemDecoration(requireContext(), layoutManager.orientation)
        binding.recyclerViewList.addItemDecoration(divider)
    }

}