package com.glp.greenlight.data.model

import androidx.room.Entity
import androidx.room.TypeConverters
import java.io.Serializable

data class ResponseData(
    val sales_area: List<SalesArea>?,
    val sales_country: List<SalesCountry>?,
    val sales_region: List<SalesRegion>?,
    val sales_zone: List<SalesZone>?
)