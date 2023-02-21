package com.ykis.ykismob.domain.address

import com.ykis.ykismob.data.cashe.user.UserCache
import com.ykis.ykismob.data.remote.address.AddressRemote
import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure
import com.ykis.ykismob.domain.type.flatMap

class AddressRepositoryImpl(
    private val remote: AddressRemote,
    private val userCache: UserCache
) :AddressRepository{
    override fun getBlocks(): Either<Failure, List<AddressEntity>> {
        return userCache.getCurrentUser()
            .flatMap { return@flatMap remote.getBlocks(it.userId,it.token) }
    }

    override fun getStreetsFromBlock(blockId: Int): Either<Failure, List<AddressEntity>> {
        return  userCache.getCurrentUser()
            .flatMap { return@flatMap remote.getStreetsFromBlock(blockId , it.userId , it.token) }
    }


}