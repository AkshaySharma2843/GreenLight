package com.glp.greenlight.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.glp.greenlight.data.repository.GreenLightRepository
import com.glp.greenlight.ui.base.BaseActivity
import com.glp.greenlight.ui.main.MainViewModel
import com.glp.greenlight.utils.common.ViewModelProviderFactory
import com.glp.greenlight.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
@Module
class ActivityModule(private val activity: BaseActivity<*, *>) {
    @Provides
    fun provideContext(
    ) : Context = activity

    @Provides
    fun provideLinearLayoutManager() : LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        greenLightRepository: GreenLightRepository
    ) : MainViewModel = ViewModelProvider(
        activity, ViewModelProviderFactory(MainViewModel::class){
            MainViewModel(schedulerProvider, compositeDisposable,greenLightRepository)
        }).get(MainViewModel::class.java)
}