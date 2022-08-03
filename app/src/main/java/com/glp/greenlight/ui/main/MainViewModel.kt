package com.glp.greenlight.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glp.greenlight.data.model.GreenLightResponseX
import com.glp.greenlight.data.repository.GreenLightRepository
import com.glp.greenlight.ui.base.BaseViewModel
import com.glp.greenlight.utils.common.Resource
import com.glp.greenlight.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    val greenLightRepository: GreenLightRepository
) : BaseViewModel(
    schedulerProvider, compositeDisposable
) {

    private val _greenLightLiveData = MutableLiveData<Resource<GreenLightResponseX?>>()
    val greenLightLiveData = _greenLightLiveData

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch(Dispatchers.IO){
            val data = greenLightRepository.fetchData()
            data.let { value ->
                _greenLightLiveData.postValue(value)
            }
        }
    }

}