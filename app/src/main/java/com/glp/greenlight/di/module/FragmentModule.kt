package com.glp.greenlight.di.module

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.glp.greenlight.data.repository.GreenLightRepository
import com.glp.greenlight.ui.base.BaseFragment
import com.glp.greenlight.ui.main.MainViewModel
import com.glp.greenlight.utils.common.ViewModelProviderFactory
import com.glp.greenlight.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
@Module
class FragmentModule(private val fragment : BaseFragment<*, *>) {
    @Provides
    @Singleton
    fun provideLinearLayoutManager() : LinearLayoutManager = LinearLayoutManager(fragment.activity)

    @Provides
    fun provideMainViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        greenLightRepository: GreenLightRepository
    ) : MainViewModel = ViewModelProvider(fragment.requireActivity(),ViewModelProviderFactory(MainViewModel::class){
            MainViewModel(schedulerProvider, compositeDisposable,greenLightRepository)
        }).get(MainViewModel::class.java)

}