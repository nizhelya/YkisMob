package com.ykis.ykismob.domain.address

import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure

interface AddressRepository {
    fun getBlocks(): Either<Failure, List<AddressEntity>>
    fun getStreetsFromBlock(blockId:Int): Either<Failure, List<AddressEntity>>
}