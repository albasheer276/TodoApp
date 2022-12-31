package it.basheer.todoapp.ui.main

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import it.basheer.todoapp.R
import it.basheer.todoapp.databinding.ActivityMainBinding
import it.basheer.todoapp.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun initial() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.activity_main_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        setupWithNavController(binding.activityMainBottomNav,navController)
    }
}