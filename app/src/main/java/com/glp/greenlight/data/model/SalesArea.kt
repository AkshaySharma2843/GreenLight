package com.glp.greenlight.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class SalesArea(
    val area: String,
    val count_unsigned_contracts: String,
    val last_month_sales: String,
    val lmsd_weighted_units: String,
    val mtd_new_selling_agents: String,
    val mtd_unit_sales: String,
    val mtd_weighted_units: String,
    val signed_contracts: String,
    val territory: String
)