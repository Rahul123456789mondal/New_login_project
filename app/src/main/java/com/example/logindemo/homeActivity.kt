package com.example.logindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem

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

    // Menue implementation
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.homeMenu -> {
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                val homeFragment = homeFragment()
                fragmentTransaction.replace(R.id.homeframeContainer, homeFragment)
                fragmentTransaction.commit()
                true
            }
            R.id.downloadMenu -> {
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                val homeFragment = DownloadFragment()
                fragmentTransaction.replace(R.id.homeframeContainer, homeFragment)
                fragmentTransaction.commit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}