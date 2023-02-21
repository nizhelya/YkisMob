package com.ykis.ykismob.data.remote.appartment

import com.ykis.ykismob.domain.appartment.AppartmentEntity
import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure

interface AppartmentRemote {
    fun getAppartmentsByUser(userId:Int, token: String): Either<Failure, List<AppartmentEntity>>
}