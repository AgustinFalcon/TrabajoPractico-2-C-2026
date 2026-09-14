package com.ifts4.trabajopractico2docuatrimestre2026

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val user = intent?.getStringExtra("username")
        binding.textViewShowName.text = "Bienvenido/a $user"*/

        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            val age = binding.etAge.text.toString()

            if (username.isNotBlank() && password.isNotBlank() && age.isNotBlank()) {
                val preferences = getSharedPreferences("Credenciales", MODE_PRIVATE)
                val edit = preferences.edit()

                edit.putString("username", username)
                edit.putString("password", password)
                edit.putInt("age", age.toInt())
                edit.apply()

            } else {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }


        Log.d("PruebaCiclosdeVida", "onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("PruebaCiclosdeVida", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("PruebaCiclosdeVida", "onResume()")
    }

    ////LAUNCHING APP
    override fun onPause() {
        super.onPause()
        Log.d("PruebaCiclosdeVida", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PruebaCiclosdeVida", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("PruebaCiclosdeVida", "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PruebaCiclosdeVida", "onDestroy()")
    }
}