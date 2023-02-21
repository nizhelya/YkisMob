package com.ykis.ykismob.data.cashe.user

import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure
import com.ykis.ykismob.domain.user.UserEntity
import javax.inject.Inject

class UserCacheImpl @Inject constructor() :UserCache{
    override fun getCurrentUser(): Either<Failure, UserEntity> {
        return Either.Right(UserEntity(8,"Petya","example@gmail.com","url","543ger245"))
    }
}