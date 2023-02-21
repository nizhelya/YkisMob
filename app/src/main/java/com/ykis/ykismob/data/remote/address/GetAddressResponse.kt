package com.ykis.ykismob.data.remote.address

import com.ykis.ykismob.data.remote.service.BaseResponse
import com.ykis.ykismob.domain.address.AddressEntity

class GetAddressResponse (
    success:Int,
    message: String,
    val address: List<AddressEntity>
) : BaseResponse(success, message)