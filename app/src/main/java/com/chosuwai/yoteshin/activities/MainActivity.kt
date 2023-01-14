package com.chosuwai.yoteshin.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.chosuwai.yoteshin.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_white_24)

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_saved -> {
                    Snackbar.make(navigationView, "Tapped Saved Movies", Snackbar.LENGTH_LONG)
                        .show()
                }
                R.id.menu_setting -> {
                    Snackbar.make(navigationView, "Tapped Setting", Snackbar.LENGTH_LONG).show()
                }
                R.id.menu_about -> {
                    Snackbar.make(navigationView, "Tapped About App", Snackbar.LENGTH_LONG).show()
                }
            }

            for (menuItemIndex in 0 until navigationView.menu.size()) {
                navigationView.menu.getItem(menuItemIndex).isChecked = false
            }
            it.isChecked = true
            drawerLayout.closeDrawer(GravityCompat.START)

            return@setNavigationItemSelectedListener true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}