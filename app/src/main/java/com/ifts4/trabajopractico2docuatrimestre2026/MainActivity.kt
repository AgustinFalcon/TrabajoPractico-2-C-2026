package com.ifts4.trabajopractico2docuatrimestre2026

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //val preferences =  lazy { getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE) }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main) //inflado
        setContentView(binding.root)

        val user = findViewById<EditText>(R.id.editTextUsuario)
        val contraseña = findViewById<EditText>(R.id.editTextContrasenha)
        val buttonIngresar = findViewById<Button>(R.id.buttonIngresar)

        /*buttonIngresar.setOnClickListener {
            Toast.makeText(this, "Bienvenido ${user.text.toString()}", Toast.LENGTH_SHORT).show()
        }*/

        binding.buttonIngresar.setOnClickListener {
            validateUser()
        }

        binding.buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("username", binding.editTextUsuario.text.toString())
            startActivity(intent)
            //Toast.makeText(this, "Bienvenido ${binding.editTextUsuario.text}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        checkAutoLogin()
    }

    private fun checkAutoLogin() {
        val preferences = getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE)
        val autoLogin = preferences.getBoolean("autoLogin", false)

        if (autoLogin) {
            navigateToHome()
        }
    }

    fun validateUser() {
        val preferences = getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE)
        val gson = Gson()
        val edit  = preferences.edit()
        // lo que almaceno el usuario
        /*val username = preferences.getString("username", "")
        val password = preferences.getString("password", "")*/

        try {
            val userInJsonFormat = preferences.getString(RegisterActivity.USER, null) /*?: return*/
            val user = gson.fromJson(userInJsonFormat, User::class.java)


            // lo que escribio el usuario en el login
            val usernameIngresado = binding.editTextUsuario.text.toString()
            val passwordIngresada = binding.editTextContrasenha.text.toString()

            if (user.username == usernameIngresado && user.password == passwordIngresada) {
                edit.putBoolean("autoLogin", binding.checkboxSession.isChecked)
                edit.apply()

                Toast.makeText(this, "Bienvenido ${usernameIngresado}", Toast.LENGTH_SHORT).show()

                navigateToHome()

            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "No hay usuario creado", Toast.LENGTH_SHORT).show()
        }

    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}