package com.glp.greenlight.data.model

import androidx.room.Entity
import java.io.Serializable

data class SalesCountry(
    val achievement: String,
    val count_unsigned_contracts: String,
    val country: String,
    val daily_runrate_current: String,
    val daily_runrate_required: String,
    val id: String,
    val last_month_sales: String,
    val lmsd_active_2_agents: String,
    val lmsd_active_agents: String,
    val lmsd_weighted_units: String,
    val mtd_active_2_agents: String,
    val mtd_active_agents: String,
    val mtd_new_selling_agents: String,
    val mtd_sales_bucket_1: String,
    val mtd_sales_bucket_2: String,
    val mtd_sales_bucket_3: String,
    val mtd_sales_bucket_4: String,
    val mtd_sales_bucket_5: String,
    val mtd_sales_bucket_6: String,
    val mtd_unit_sales: String,
    val mtd_weighted_units: String,
    val percent_agent_met: String,
    val sales_monthly_goal: String,
    val signed_contracts: String,
    val territory: String,
    val today_sales: String,
    val yesterday_sales: String
)