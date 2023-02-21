package com.ykis.ykismob.domain.appartment

import com.ykis.ykismob.domain.type.UseCase
import javax.inject.Inject

class GetAppartments  @Inject constructor(
    private val appartmentRepository: AppartmentRepository
) : UseCase<List<AppartmentEntity>, Boolean>() {

    override suspend fun run(needFetch: Boolean) = appartmentRepository.getAppartmentsByUser(needFetch)
}