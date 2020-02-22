package com.soarmorrow.bms.app

import android.app.Application
import com.soarmorrow.bms.di.mainModdule
import com.soarmorrow.bms.di.registerModule
import org.koin.android.ext.android.startKoin

class BmsApp : Application()
{
    override fun onCreate() {
        super.onCreate()
        startKoin(this,
            listOf(mainModdule, registerModule),
            loadPropertiesFromFile = true)
    }

}