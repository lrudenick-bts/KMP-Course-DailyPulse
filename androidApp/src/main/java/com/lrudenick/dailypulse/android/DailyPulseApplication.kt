package com.lrudenick.dailypulse.android

import android.app.Application
import com.lrudenick.dailypulse.android.di.databaseModule
import com.lrudenick.dailypulse.android.di.viewModelsModule
import com.lrudenick.dailypulse.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@DailyPulseApplication)
            modules(modules)
        }
    }
}