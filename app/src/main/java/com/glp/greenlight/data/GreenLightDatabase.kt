package com.glp.greenlight.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.glp.greenlight.BuildConfig
import com.glp.greenlight.data.model.GreenLightResponseX
import com.glp.greenlight.data.model.SalesZone
import com.glp.greenlight.utils.common.GreenTypeConvertor

/**
 * Created by Akshay Sharma on 03-08-2022.
 */
@Database(entities = [GreenLightResponseX::class], version = BuildConfig.VERSION_CODE, exportSchema = false)
@TypeConverters(GreenTypeConvertor::class)
abstract class GreenLightDatabase : RoomDatabase() {

    abstract fun greenDao() : GreenLightDao

}