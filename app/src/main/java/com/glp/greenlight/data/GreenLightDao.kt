package com.glp.greenlight.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.glp.greenlight.data.model.GreenLightResponseX
import retrofit2.http.GET

/**
 * Created by Akshay Sharma on 03-08-2022.
 */

@Dao
interface GreenLightDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(responseData : GreenLightResponseX) : Long

    @Query("SELECT * FROM greenLightTable")
    suspend fun getData() : GreenLightResponseX?
}