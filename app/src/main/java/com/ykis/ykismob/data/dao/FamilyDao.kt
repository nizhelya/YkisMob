package com.ykis.ykismob.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.ykis.ykismob.domain.family.FamilyEntity

@Dao
interface FamilyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFamily(appartment:List<FamilyEntity>)
}
