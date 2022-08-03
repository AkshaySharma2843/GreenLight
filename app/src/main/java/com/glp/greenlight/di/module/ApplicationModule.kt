package com.glp.greenlight.di.module

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.glp.greenlight.GreenLightApplication
import com.glp.greenlight.data.GreenLightDatabase
import com.glp.greenlight.data.model.GreenLightResponseX
import com.glp.greenlight.data.network.NetworkService
import com.glp.greenlight.data.network.Networking
import com.glp.greenlight.data.repository.GreenLightRepository
import com.glp.greenlight.utils.network.NetworkHelper
import com.glp.greenlight.utils.rx.RxSchedulerProvider
import com.glp.greenlight.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Akshay Sharma on 03-08-2022.
 */

@Module
class ApplicationModule(private val application : GreenLightApplication) {

    @Provides
    fun provideContext() : Context = application

    @Provides
    fun provideRetrofitInstance() : NetworkService = Networking.create()

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    fun provideNetworkHelper() = NetworkHelper(application)

    @Provides
    fun provideDatabaseService() = Room.databaseBuilder(application, GreenLightDatabase::class.java, "db", ).build()

    @Provides
    fun provideRepository(networkService: NetworkService, greenLightDatabase: GreenLightDatabase, networkHelper: NetworkHelper) = GreenLightRepository(networkService, greenLightDatabase, networkHelper)

}