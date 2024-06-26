package com.example.simulacros.ui._main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.example.simulacros.R
import com.example.simulacros.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private val fragmentsNavigation = setOf(
        R.id.navigation_search_result,
        R.id.navigation_offers,
        R.id.navigation_preference,
        R.id.navigation_profile,
        R.id.navigation_search_result_detail,
        R.id.fragment_explore,
        R.id.fragmentSearch
    )

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.contentMainInclude.customToolbar)
        navController = findNavController(R.id.nav_host_fragment_activity_main)

        val navView: BottomNavigationView = binding.navView
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = fragmentsNavigation,
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )

        //Configuro Toolbar
        binding.contentMainInclude.customToolbar.setupWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //Configuro NavigationView
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        binding.navigationView.setupWithNavController(navController)

        //Configuro Comportamiento segun Fragmento
        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->

            when (destination.id) {
                R.id.navigation_offers,
                R.id.navigation_preference,
                R.id.navigation_profile,
                R.id.fragment_explore,
                R.id.fragmentSearch,
                -> {
                    navView.visibility = BottomNavigationView.VISIBLE
                    binding.contentMainInclude.customToolbar.visibility = MaterialToolbar.VISIBLE
                }
                else -> {
                    navView.visibility = BottomNavigationView.GONE
                    binding.contentMainInclude.customToolbar.visibility = View.GONE
                }
            }
            when(destination.id) {
                R.id.navigation_search_result,
                R.id.navigation_search_result_detail
                -> {
                    binding.contentMainInclude.customToolbar.visibility = MaterialToolbar.VISIBLE
                }
            }
            //Para ciertas vistas seteo el icono fijo al hamburger
            when (destination.id) {
                R.id.fragment_explore,
                ->{
                    supportActionBar?.setHomeAsUpIndicator(R.drawable.hamburger)
                }
            }
        }
        loadPreferences()
    }

    override fun onSupportNavigateUp(): Boolean {
        //Fuezo al boton de navegación de la toolbar que solo abra el menú Drawer
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }

    private fun loadPreferences() {
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        if (prefs.getBoolean(getString(R.string.preference_night_mode_key), false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}