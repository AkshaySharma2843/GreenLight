package com.glp.greenlight

import android.app.Application
import android.content.Context
import com.glp.greenlight.di.component.ApplicationComponent
import com.glp.greenlight.di.component.DaggerApplicationComponent
import com.glp.greenlight.di.module.ApplicationModule

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class GreenLightApplication : Application() {

    lateinit var applicationComponent :ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)


    }

}