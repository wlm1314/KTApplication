package com.wsy.ktapplication.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.wsy.ktapplication.R
import com.wsy.ktapplication.base.BaseAty
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseAty(), NavigationView.OnNavigationItemSelectedListener {
    private var homeFragment:HomeFragment?=null

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        homeFragment = HomeFragment()
    }

    override fun initData() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layout_frame, homeFragment!!)
            .commit()

        fab.setOnClickListener {
            Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                Snackbar.make(fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_news -> {
                toolbar.title = resources.getString(R.string.nav_home)
            }
            R.id.nav_game -> {
                toolbar.title = resources.getString(R.string.nav_game)
            }
            R.id.nav_movie -> {
                toolbar.title = resources.getString(R.string.nav_movie)
            }
            R.id.nav_design -> {
                toolbar.title = resources.getString(R.string.nav_design)
            }
            R.id.nav_bigcompany -> {
                toolbar.title = resources.getString(R.string.nav_bigcompany)
            }
            R.id.nav_finance -> {
                toolbar.title = resources.getString(R.string.nav_finance)
            }
            R.id.nav_music -> {
                toolbar.title = resources.getString(R.string.nav_music)
            }
            R.id.nav_physical -> {
                toolbar.title = resources.getString(R.string.nav_physical)
            }
            R.id.nav_anime -> {
                toolbar.title = resources.getString(R.string.nav_anime)
            }
            R.id.nav_internet -> {
                toolbar.title = resources.getString(R.string.nav_internet)
            }
            R.id.nav_unrogue -> {
                toolbar.title = resources.getString(R.string.nav_unrogue)
            }
            R.id.nav_recommend -> {
                toolbar.title = resources.getString(R.string.nav_recommend)
            }
            R.id.nav_dailypsychology -> {
                toolbar.title = resources.getString(R.string.nav_dailypsychology)
            }
            R.id.nav_theme -> {
                val boolean = getPreference().getBoolean("theme", false)
                if (boolean) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                getPreference().edit().putBoolean("theme", !boolean).apply();
                recreate()
            }
            R.id.nav_setting -> {
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}