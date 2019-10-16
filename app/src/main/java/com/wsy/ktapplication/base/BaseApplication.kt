package com.wsy.ktapplication.base

import android.app.Application

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Inner.app = this;
    }

    companion object{
        fun getInstance():BaseApplication{
            return Inner.app!!
        }
    }

    private object Inner {
        var app:BaseApplication ?= null
    }

}