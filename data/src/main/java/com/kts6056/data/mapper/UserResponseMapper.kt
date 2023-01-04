package com.kts6056.data.mapper

import com.kts6056.data.model.remote.UserResponse
import com.kts6056.domain.model.User

internal object UserResponseMapper : Mapper<UserResponse, User> {
    override fun mapDomain(input: UserResponse): User = with(input) {
        User(
            id = id,
            name = name,
            profileUrl = profileUrl,
            webUrl = webUrl
        )
    }
}
