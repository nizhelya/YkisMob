package com.ykis.ykismob.data.remote.address

import com.ykis.ykismob.domain.address.AddressEntity
import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure

interface AddressRemote {
    fun getBlocks(userId:Int, token: String): Either<Failure, List<AddressEntity>>
    fun getStreetsFromBlock(blockId:Int, userId:Int, token: String): Either<Failure, List<AddressEntity>>
}