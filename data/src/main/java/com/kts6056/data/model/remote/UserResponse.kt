package com.kts6056.data.model.remote

import com.kts6056.data.model.ResponseModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
internal data class UserResponse(
    @SerialName("id") val id: Long,
    @SerialName("login") val name: String,
    @SerialName("avatar_url") val profileUrl: String,
    @SerialName("html_url") val webUrl: String
) : ResponseModel
