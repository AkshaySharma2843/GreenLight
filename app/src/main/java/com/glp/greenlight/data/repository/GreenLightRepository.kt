package com.glp.greenlight.data.repository

import com.glp.greenlight.data.GreenLightDao
import com.glp.greenlight.data.GreenLightDatabase
import com.glp.greenlight.data.model.GreenLightResponseX
import com.glp.greenlight.data.network.NetworkService
import com.glp.greenlight.utils.common.Resource
import com.glp.greenlight.utils.network.NetworkHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class GreenLightRepository @Inject constructor(
    private val networkService: NetworkService,
    databaseService : GreenLightDatabase,
    private val networkHelper : NetworkHelper
) {
    private var databaseDao : GreenLightDao = databaseService.greenDao()


    suspend fun fetchData(): Resource<GreenLightResponseX?> {
        return if(networkHelper.isNetworkAvailable()){
            createRealNetworkCall()
        }
        else
        {
            return if(databaseDao.getData() != null){
                Resource.success(databaseDao.getData())
            } else {
                Resource.error()
            }
        }
    }

   private suspend fun createRealNetworkCall() : Resource<GreenLightResponseX?> {
        withContext(Dispatchers.IO){
            val data = networkService.createApiCall()
            databaseDao.insertData(data)
        }
       return  Resource.success(databaseDao.getData())
    }
}