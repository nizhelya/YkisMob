package com.ykis.ykismob.data.cashe.appartment

import com.ykis.ykismob.data.dao.AppartmentDao
import com.ykis.ykismob.domain.appartment.AppartmentEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppartmentCacheImpl @Inject constructor(
    private val appartmentDao: AppartmentDao
):AppartmentCache {

//    override suspend fun updateAppartment(appartment: AppartmentEntity) {
//        appartmentDao.updateAppartment(appartment)
//    }
//
//    override suspend fun deleteAppartment(appartment: AppartmentEntity) {
//        appartmentDao.deleteAppartment(appartment)
//    }
//
//    override suspend fun getAppartment(): Flow<List<AppartmentEntity>> {
//        return  appartmentDao.getAppartments()
//    }

    override fun addAppartmentByUser(appartment: List<AppartmentEntity>) {
        appartmentDao.addAppartmentByUser(appartment)
    }

    override fun getAppartmentsByUser(): List<AppartmentEntity> {
        return appartmentDao.getAppartmentsByUser()
    }

    override fun deleteAllAppartments(userId:Int) {
        appartmentDao.deleteAllAppartments(userId)
    }


}