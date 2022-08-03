package com.glp.greenlight.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
interface SchedulerProvider {
    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}