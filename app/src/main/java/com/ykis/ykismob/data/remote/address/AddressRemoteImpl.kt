package com.ykis.ykismob.data.remote.address

import com.ykis.ykismob.data.remote.service.ApiService
import com.ykis.ykismob.data.remote.service.Request
import com.ykis.ykismob.domain.address.AddressEntity
import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressRemoteImpl @Inject constructor(
    private val request: Request,
    private val service: ApiService
) : AddressRemote {

    override fun getBlocks(
        userId: Int,
        token: String
    ): Either<Failure, List<AddressEntity>> {
        return request.make(
            service.getBlocks(
                createGetBlocksMap(
                    userId,
                    token
                )
            )
        ) {
            it.address
        }
    }

    override fun getStreetsFromBlock(
        blockId: Int,
        userId: Int,
        token: String
    ): Either<Failure, List<AddressEntity>> {
        return request.make(
            service.getStreetsFromBlock(
                createGetStreetsMap(
                    blockId,
                    userId,
                    token
                )
            )
        ) {
            it.address
        }
    }


    private fun createGetBlocksMap(userId: Int, token: String): Map<String, String> {
        val map = HashMap<String, String>()
        map.put(ApiService.PARAM_USER_ID, userId.toString())
        map.put(ApiService.PARAM_TOKEN, token)
        return map
    }
    private fun createGetStreetsMap(blockId:Int,userId: Int, token: String): Map<String, String> {
        val map = HashMap<String, String>()
        map.put(ApiService.BLOCK_ID, blockId.toString())
        map.put(ApiService.PARAM_USER_ID, userId.toString())
        map.put(ApiService.PARAM_TOKEN, token)
        return map
    }
}