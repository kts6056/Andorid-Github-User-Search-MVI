package com.kts6056.data.model.remote

import com.kts6056.data.model.ResponseModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
internal data class SearchUserResponse(
    @SerialName("items") val items: List<UserResponse>
) : ResponseModel
