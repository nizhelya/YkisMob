package com.ykis.ykismob.domain.appartment

import com.ykis.ykismob.data.cashe.appartment.AppartmentCache
import com.ykis.ykismob.data.cashe.user.UserCache
import com.ykis.ykismob.data.remote.appartment.AppartmentRemote
import com.ykis.ykismob.domain.type.*

class AppartmentRepositoryImpl (private val appartmentRemote: AppartmentRemote,
                                private val appartmentCache: AppartmentCache,
                                private val userCache: UserCache
):AppartmentRepository{
    override fun getAppartmentsByUser(needFetch: Boolean): Either<Failure, List<AppartmentEntity>> {
        return userCache.getCurrentUser()
            .flatMap {
                return@flatMap if (needFetch) {
                    appartmentCache.deleteAllAppartments(it.userId)
                    appartmentRemote.getAppartmentsByUser(it.userId,it.token)
                } else {
                    Either.Right(appartmentCache.getAppartmentsByUser())
                }
            }
            .map { it.sortedBy { it.address } }
            .onNext { it.map { appartmentCache.addAppartmentByUser(listOf(it)) } }
    }
}