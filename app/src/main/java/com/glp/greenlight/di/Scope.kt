package com.glp.greenlight.di

import javax.inject.Scope

/**
 * Created by Akshay Sharma on 03-08-2022.
 */

    @Scope
    @Retention(AnnotationRetention.SOURCE)
    annotation class ActivityScope

    @Scope
    @Retention(AnnotationRetention.SOURCE)
    annotation class FragmentScope
