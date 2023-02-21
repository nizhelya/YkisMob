package com.ykis.ykismob.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ykis.ykismob.domain.appartment.AppartmentEntity

@Dao
interface AppartmentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAppartmentByUser(appartment:List<AppartmentEntity>)

    //    @Update
//    suspend fun updateAppartment(appartment: AppartmentEntity)
//
    @Query("delete from appartment where user_id != :userId")
    fun deleteAllAppartments(userId:Int)
//
//    @Query("select * from appartment where address_id= :addressId")
//    fun getAppartment(addressId:Int): List<AppartmentEntity>

    @Query("select * from appartment")
    fun getAppartmentsByUser(): List<AppartmentEntity>

//    @Query("select * from appartment")
//    fun getAppartments():Flow<List<AppartmentEntity>>
}