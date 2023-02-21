package com.ykis.ykismob.data.remote.appartment

import com.ykis.ykismob.data.remote.service.ApiService
import com.ykis.ykismob.data.remote.service.Request
import com.ykis.ykismob.domain.appartment.AppartmentEntity
import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppartmentRemoteImpl @Inject constructor(
    private val request: Request,
    private val service: ApiService
) : AppartmentRemote {

    override fun getAppartmentsByUser(
        userId: Int,
        token: String
    ): Either<Failure, List<AppartmentEntity>> {
        return request.make(
            service.getAppartmentsByUser(
                createGetAppartmentsByUserMap(
                    userId,
                    token
                )
            )
        ) {
            it.appartments
        }
    }

    private fun createGetAppartmentsByUserMap(userId: Int, token: String): Map<String, String> {
        val map = HashMap<String, String>()
        map.put(ApiService.PARAM_USER_ID, userId.toString())
        map.put(ApiService.PARAM_TOKEN, token)
        return map
    }
}