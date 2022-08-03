package com.glp.greenlight.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.glp.greenlight.utils.common.GreenTypeConvertor

@Entity(tableName = "greenLightTable")
data class GreenLightResponseX(
    @PrimaryKey(autoGenerate = false)
    val id : Int = 0,

    @TypeConverters(GreenTypeConvertor::class)
    val ResponseData: ResponseData,
    val ResponseStatus: Int,
    val Success: Boolean
)