package com.ykis.ykismob.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ykis.ykismob.domain.appartment.AppartmentEntity
import com.ykis.ykismob.domain.family.FamilyEntity

@Database(entities = [AppartmentEntity::class , FamilyEntity::class] , version = 1 ,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appartmentDao(): AppartmentDao
    abstract fun familyDao(): FamilyDao

    companion object{
        val DATABASE_NAME:String = "mykis_db"
    }
}