package com.glp.greenlight.di.component

import com.glp.greenlight.GreenLightApplication
import com.glp.greenlight.data.repository.GreenLightRepository
import com.glp.greenlight.di.module.ApplicationModule
import com.glp.greenlight.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 03-08-2022.
 */

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(greenLightApplication: GreenLightApplication)
    fun getSchedulerProvider(): SchedulerProvider
    fun getCompositeDisposable(): CompositeDisposable
    fun getRepo(): GreenLightRepository

}