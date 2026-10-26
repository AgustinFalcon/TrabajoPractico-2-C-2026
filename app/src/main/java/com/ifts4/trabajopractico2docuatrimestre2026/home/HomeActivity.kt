package com.ifts4.trabajopractico2docuatrimestre2026.home

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import com.ifts4.trabajopractico2docuatrimestre2026.R
import com.ifts4.trabajopractico2docuatrimestre2026.RegisterActivity
import com.ifts4.trabajopractico2docuatrimestre2026.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var navController: NavController


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

        /*if (savedInstanceState == null) {
            replaceFragment(FirstFragment())
            binding.navigationView.setCheckedItem(R.id.nav_item_one)
        }*/

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        drawerLayout.addDrawerListener(toggle)
        binding.navigationView.setNavigationItemSelectedListener(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_burguer)
    }

    /*private fun replaceFragment(fragment: Fragment) {
        val transition = supportFragmentManager.beginTransaction()
        transition.replace(R.id.fragmentContainerView, fragment)
        transition.commit()
    }*/

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_item_one -> {
                //replaceFragment(FirstFragment())
                navController.navigate(R.id.firstFragment)
                Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_item_two -> {
                //replaceFragment(SecondFragment())
                navController.navigate(R.id.secondFragment)
                Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_item_three -> {
                //replaceFragment(ListFragment())
                navController.navigate(R.id.listFragment)
                Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}