package com.glp.greenlight.utils.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
data class NetworkError(
    val status: Int = -1,
    @Expose
    @SerializedName("statusCode")
    val statusCode: String = "-1",
    @Expose
    @SerializedName("message")
    val message: String = "Something went wrong"
)
