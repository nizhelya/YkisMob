package com.ykis.ykismob.data.cashe.appartment

import com.ykis.ykismob.domain.appartment.AppartmentEntity


interface AppartmentCache {
    fun addAppartmentByUser(appartment:List<AppartmentEntity>)
    fun getAppartmentsByUser():List<AppartmentEntity>
    fun deleteAllAppartments(userId:Int)
    //    suspend fun updateAppartment(appartment: AppartmentEntity)
    //    suspend fun deleteAppartment(appartment: AppartmentEntity)
}