package com.glp.greenlight.di.component

import com.glp.greenlight.di.FragmentScope
import com.glp.greenlight.di.module.FragmentModule
import com.glp.greenlight.ui.area.AreaFragment
import com.glp.greenlight.ui.fragment.FragmentOne
import com.glp.greenlight.ui.fragment.FragmentTwo
import com.glp.greenlight.ui.region.RegionFragment
import com.glp.greenlight.ui.zone.ZoneFragment
import dagger.Component

/**
 * Created by Akshay Sharma on 03-08-2022.
 */

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(zoneFragment: ZoneFragment)
    fun inject(areaFragment: AreaFragment)
    fun inject(regionFragment: RegionFragment)
    fun inject(one: FragmentOne)
    fun inject(two: FragmentTwo)
}