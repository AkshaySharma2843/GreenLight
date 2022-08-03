package com.glp.greenlight.ui.region

import com.glp.greenlight.data.model.SalesRegion

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
interface PostClickListener {
    fun onRegionClick(salesRegion: SalesRegion,position:Int)
}