package com.ifts4.trabajopractico2docuatrimestre2026.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ifts4.trabajopractico2docuatrimestre2026.MainActivity
import com.ifts4.trabajopractico2docuatrimestre2026.R
import com.ifts4.trabajopractico2docuatrimestre2026.RegisterActivity
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val preferences = activity?.getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE)

        binding.btnSingOut.setOnClickListener {
            preferences?.let {
                it.edit()?.clear()?.apply()
                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
            }
        }
    }


}