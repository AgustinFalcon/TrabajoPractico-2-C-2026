package com.ifts4.trabajopractico2docuatrimestre2026.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ifts4.trabajopractico2docuatrimestre2026.R
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val secondViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        binding.etEmail.addTextChangedListener { email ->
            secondViewModel.validateEmail(email = email.toString())
        }

        binding.etPassword.addTextChangedListener { password ->
            secondViewModel.validatePassword(password = password.toString())
        }

        secondViewModel.viewState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                SecondStateSealed.SuccessEmail -> {
                    binding.layoutEmail.error = null
                }

                SecondStateSealed.ErrorEmail -> {
                    binding.layoutEmail.error = "Formato de email invalido"
                }

                SecondStateSealed.SuccessPassword -> {
                    binding.layoutPassword.error = null
                }

                is SecondStateSealed.ErrorPassword -> {
                    binding.layoutPassword.error = "${state.password.length}/4 caracteres"
                }

                SecondStateSealed.SuccessButton -> {
                    binding.btnNext.isEnabled = true
                }

                SecondStateSealed.ErrorButton -> {
                    binding.btnNext.isEnabled = false
                }
            }
        })
    }

}