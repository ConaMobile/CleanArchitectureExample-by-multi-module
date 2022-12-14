package com.conamobile.cleanarchitectureexample

import android.app.Application
import com.conamobile.cleanarchitectureexample.di.AppComponent
import com.conamobile.cleanarchitectureexample.di.DaggerAppComponent
import javax.inject.Inject

class App @Inject constructor() : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .factory()
            .create(this)

        appComponent.inject(this)
    }
}