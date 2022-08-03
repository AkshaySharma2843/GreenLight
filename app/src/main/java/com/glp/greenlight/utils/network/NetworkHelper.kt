package com.glp.greenlight.utils.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.glp.greenlight.GreenLightApplication
import javax.inject.Inject

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class NetworkHelper(private val context : Context) {
    fun isNetworkAvailable(): Boolean {
        val mConnectivityManager = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (mConnectivityManager != null) {
            val mNetworkInfos = mConnectivityManager.allNetworkInfo
            if (mNetworkInfos != null) {
                for (mNetworkInfo in mNetworkInfos) {
                    if (mNetworkInfo.state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
                }
            }
        }
        return false
    }

}