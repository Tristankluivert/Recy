package com.kluivert.recy

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.MediaController
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_nav_play.*

class NavPlay : AppCompatActivity() {

      lateinit var drawerLayout: DrawerLayout

    lateinit var navController: NavController
   //lateinit var listener : NavController.OnDestinationChangedListener

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_play)

        drawerLayout = findViewById(R.id.drawerLayout)
        navController = findNavController(R.id.navfragment)


          navImage.setOnClickListener {
              drawerLayout.openDrawer(GravityCompat.START)
          }
        naView.itemIconTintList = null
        NavigationUI.setupWithNavController(naView,navController)

             //  window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE


       /* listener = NavController.OnDestinationChangedListener{controller, destination, arguments ->
        if(destination.id == R.id.firstFrag){
             supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.colorAccent)))
            window.statusBarColor = getColor(R.color.colorAccent)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_message)
        }else if(destination.id == R.id.secondFrag){
            supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.white)))
            window.statusBarColor = getColor(R.color.white)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }else if(destination.id == R.id.thirdFrag){
            supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.colorPrimaryDark)))
            window.statusBarColor = getColor(R.color.colorPrimaryDark)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }*/


    }

 /*   override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)
    }*/


}