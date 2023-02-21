package com.ykis.ykismob.data.remote.appartment

import com.ykis.ykismob.data.remote.service.BaseResponse
import com.ykis.ykismob.domain.appartment.AppartmentEntity

class GetAppartmentsResponse (
    success:Int,
    message: String,
    val appartments: List<AppartmentEntity>
) : BaseResponse(success, message)