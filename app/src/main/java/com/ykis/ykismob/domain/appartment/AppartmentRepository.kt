package com.ykis.ykismob.domain.appartment

import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure

interface AppartmentRepository {
    fun getAppartmentsByUser(needFetch: Boolean): Either<Failure, List<AppartmentEntity>>
}