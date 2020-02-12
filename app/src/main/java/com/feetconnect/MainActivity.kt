package com.feetconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_view: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.mainfragment,
                R.id.loginfragment
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        nav_view.setupWithNavController(navController)
    }
}

// Create a method only AppCompactActivity and after you use in the project when we call
// the AppCompactActivity
fun AppCompatActivity.replaceFragment(fragment: Fragment){
    // Created variable for recover the methods
    val fragmentManager = supportFragmentManager
    // Created variable for realized the transaction with fragment and application method
    // beginTransaction()
    val transaction = fragmentManager.beginTransaction()
    // Here, we target the fragment element which is in the activity_main.xml
    // and fragment replace as argument
    transaction.replace(R.id.fragment,fragment)
    // This method permit to back in the fragment prevent with the button return of the phone
    transaction.addToBackStack(null)
    // Commit for execute the method
    transaction.commit()
}


