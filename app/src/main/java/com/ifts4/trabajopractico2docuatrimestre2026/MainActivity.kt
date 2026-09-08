package com.ifts4.trabajopractico2docuatrimestre2026

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main) //inflado
        setContentView(binding.root)

        val user = findViewById<EditText>(R.id.editTextUsuario)
        val contraseña = findViewById<EditText>(R.id.editTextContraseña)
        val buttonIngresar = findViewById<Button>(R.id.buttonIngresar)

        /*buttonIngresar.setOnClickListener {
            Toast.makeText(this, "Bienvenido ${user.text.toString()}", Toast.LENGTH_SHORT).show()
        }*/

        binding.buttonIngresar.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra("username", binding.editTextUsuario.text.toString())
            startActivity(intent)
            //Toast.makeText(this, "Bienvenido ${binding.editTextUsuario.text}", Toast.LENGTH_SHORT).show()
        }
    }

}