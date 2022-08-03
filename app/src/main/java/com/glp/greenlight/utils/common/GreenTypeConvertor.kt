package com.glp.greenlight.utils.common

import androidx.room.TypeConverter
import com.glp.greenlight.data.model.GreenLightResponseX
import com.glp.greenlight.data.model.ResponseData
import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


/**
 * Created by Akshay Sharma on 03-08-2022.
 */
class GreenTypeConvertor {

    @TypeConverter
    fun fromObjectToString(list: ResponseData?): String? {
        val gson = Gson()
        return gson.toJson(list)
    }

    @TypeConverter
    fun fromStringToObject(value: String?): ResponseData? {
        val listType: Type = object : TypeToken<ResponseData?>() {}.type
        return Gson().fromJson(value, listType)
    }


}