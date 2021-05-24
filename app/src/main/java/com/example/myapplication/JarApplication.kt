package com.example.myapplication

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class JarApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        TODO("Not yet implemented")
    }
}