package com.glp.greenlight.di.component

import com.glp.greenlight.di.ActivityScope
import com.glp.greenlight.di.module.ActivityModule
import com.glp.greenlight.ui.main.MainActivity
import dagger.Component

/**
 * Created by Akshay Sharma on 03-08-2022.
 */

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(activity : MainActivity)

}