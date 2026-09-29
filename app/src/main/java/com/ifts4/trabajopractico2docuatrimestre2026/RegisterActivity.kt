package com.ifts4.trabajopractico2docuatrimestre2026

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityRegisterBinding

    val arrayColors: Array<Colors> = Colors.entries.toTypedArray()

    var colorSelected: Colors? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val user = intent?.getStringExtra("username")
        binding.textViewShowName.text = "Bienvenido/a $user"*/

        val adapter = ArrayAdapter(this, R.layout.my_simple_spinner_item, arrayColors)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = this

        binding.btnRegister.setOnClickListener {
            saveUser()
        }


        Log.d("PruebaCiclosdeVida", "onCreate()")
    }

    private fun saveUser() {
        val username = binding.etUsername.text.toString()
        val password = binding.etPassword.text.toString()
        val age = binding.etAge.text.toString()

        if (username.isNotBlank() && password.isNotBlank() && age.isNotBlank() && colorSelected != null) {
            val preferences = getSharedPreferences(CREDENCIALES, MODE_PRIVATE)
            val edit = preferences.edit()

            //Creo el objeto
            val user = User(username = username, password = password, age = age.toInt(), color = colorSelected!!)

            // casteo a json
            val gson = Gson()
            val userInJsonFormat = gson.toJson(user)

            // almaceno
            edit.putString(USER, userInJsonFormat)
            edit.apply()

            goToMainActivity()

            /*edit.putString("username", username)
            edit.putString("password", password)
            edit.putInt("age", age.toInt())*/

        } else {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onItemSelected(
        p0: AdapterView<*>?, p1: View?, position: Int, p3: Long
    ) {
        colorSelected = arrayColors[position]
        Toast.makeText(this, "Seleccionaste ${arrayColors[position]}", Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        colorSelected = null
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


    companion object {
        const val CREDENCIALES = "Credenciales"
        const val USER = "usuario"
    }
}