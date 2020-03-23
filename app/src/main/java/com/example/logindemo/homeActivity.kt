package com.example.logindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class homeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val homeFragment = homeFragment()
        fragmentTransaction.add(R.id.homeframeContainer, homeFragment)
        fragmentTransaction.commit()
    }
}