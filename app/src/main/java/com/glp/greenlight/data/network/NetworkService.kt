package com.glp.greenlight.data.network

import com.glp.greenlight.data.model.GreenLightResponseX
import retrofit2.http.GET

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
interface NetworkService {

    @GET("v3/286f38b4-c6c1-4348-aabc-6d396dcbc4de")
    suspend fun createApiCall() : GreenLightResponseX
}