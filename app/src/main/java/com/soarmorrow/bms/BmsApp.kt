package com.soarmorrow.bms

import android.app.Application
import org.koin.android.ext.android.startKoin

class BmsApp : Application()
{
    override fun onCreate() {
        super.onCreate()
        startKoin(this,
            listOf(mainModule),
            loadPropertiesFromFile = true)
    }

}