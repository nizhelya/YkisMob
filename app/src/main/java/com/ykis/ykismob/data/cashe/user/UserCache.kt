package com.ykis.ykismob.data.cashe.user

import com.ykis.ykismob.domain.type.Either
import com.ykis.ykismob.domain.type.Failure
import com.ykis.ykismob.domain.user.UserEntity

interface UserCache {
    fun getCurrentUser(): Either<Failure, UserEntity>
}