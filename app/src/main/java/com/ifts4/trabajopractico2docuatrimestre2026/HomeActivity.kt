package com.ifts4.trabajopractico2docuatrimestre2026

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ActivityHomeBinding
import com.ifts4.trabajopractico2docuatrimestre2026.fragments.FirstFragment
import com.ifts4.trabajopractico2docuatrimestre2026.fragments.SecondFragment
import com.ifts4.trabajopractico2docuatrimestre2026.fragments.ThirdFragment

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE)

        /*binding.btnSalir.setOnClickListener {
            preferences.edit().clear().apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/

        val toolbar: Toolbar = binding.toolBar
        setSupportActionBar(toolbar)

        drawerLayout = binding.drawerLayout
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer_layout,
            R.string.close_drawer_layout
        )

        if (savedInstanceState == null) {
            replaceFragment(FirstFragment())
            binding.navigationView.setCheckedItem(R.id.nav_item_one)
        }

        drawerLayout.addDrawerListener(toggle)
        binding.navigationView.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_burguer)
    }

    private fun replaceFragment(fragment: Fragment) {
        val transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.fragmentContainerView, fragment)
        transition.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_one -> {
                replaceFragment(FirstFragment())
                Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_item_two -> {
                replaceFragment(SecondFragment())
                Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_item_three -> {
                replaceFragment(ThirdFragment())
                Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}