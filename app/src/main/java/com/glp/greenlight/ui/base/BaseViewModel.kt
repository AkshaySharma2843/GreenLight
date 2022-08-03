package com.glp.greenlight.ui.base

import androidx.lifecycle.ViewModel
import com.glp.greenlight.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
abstract class BaseViewModel(
    protected val schedulerProvider: SchedulerProvider,
    protected val compositeDisposable: CompositeDisposable,
) : ViewModel() {

    fun handleNetworkError(){

    }
}