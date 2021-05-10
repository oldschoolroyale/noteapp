package com.brmlab.sqlite.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.brmlab.sqlite.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.mainNavHost))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navCont = findNavController(R.id.mainNavHost)
        return super.onSupportNavigateUp() || navCont.navigateUp()
    }
}