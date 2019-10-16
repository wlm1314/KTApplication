package com.wsy.ktapplication.base

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.wsy.ktapplication.R

abstract class BaseAty :AppCompatActivity(){
    private var preference: SharedPreferences? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
        initView()
        initData()
    }

    @LayoutRes
    abstract fun getLayout(): Int

    abstract fun initView()

    abstract fun initData()

    fun getPreference() : SharedPreferences {
        if (preference == null) {
            preference = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        }
        return preference!!
    }

    fun setToolBar(toolbar: Toolbar, title: String) {
        toolbar.title = title + ""
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    fun setToolBarNoBack(toolbar: Toolbar, title: String) {
        toolbar.title = title + ""
        setSupportActionBar(toolbar)
    }
}