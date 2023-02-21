package com.ykis.ykismob.domain.appartment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "appartment")
data class AppartmentEntity(
    val id: Int,

    @Json(name = "user_id")
    @ColumnInfo(name = "user_id")
    val userId: Int,

    @PrimaryKey(autoGenerate = false)
    @Json(name = "address_id")
    @ColumnInfo(name = "address_id")
    val addressId: Int = 0,

    val address: String = "Unknown",
    var nanim: String = "Unknown",
    var fio: String = "Unknown",
    var order: String = "Unknown",

    @Json(name = "data")
    @ColumnInfo(name = "data")
    var dataOrder: String = "Unknown",

    @Json(name = "area_full")
    @ColumnInfo(name = "area_full")
    var areaFull: Double = 0.00,

    @Json(name = "area_life")
    @ColumnInfo(name = "area_life")
    var areaLife: Double = 0.00,

    @Json(name = "area_dop")
    @ColumnInfo(name = "area_dop")
    var areaDop: Double = 0.00,

    @Json(name = "area_balk")
    @ColumnInfo(name = "area_balk")
    var areaBalk: Double = 0.00,

    @Json(name = "area_otopl")
    @ColumnInfo(name = "area_otopl")
    var areaOtopl: Double = 0.00,

    var tenant: Int = 0,
    var podnan: Int = 0,
    var absent: Int = 0,
    var email: String = "Unknown",
    var phone: String = "Unknown",
    var kod: String = "Unknown"
)