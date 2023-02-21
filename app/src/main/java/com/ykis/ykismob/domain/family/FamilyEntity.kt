package com.ykis.ykismob.domain.family

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "family")
data class FamilyEntity(
    @PrimaryKey(autoGenerate = true)
    @Json(name = "rec_id")
    @ColumnInfo(name = "rec_id")
    var recId :Int ,
    @Json(name = "address_id")
    @ColumnInfo(name = "address_id")
    var addressId :Int ,

    var fistName :String = "Unknown",
    var lastName :String = "Unknown" ,
    var surName :String = "Unknown" ,

    var born :String,

    var sex:String = "Unknown" ,

    var phone:String = "Unknown"
)
