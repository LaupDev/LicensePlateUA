package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

// TODO: Add api

data class CommentDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val userName: String?,
    @Json(name = "text") val text: String?,
    @Json(name = "created_at") val createdAt: String?,
    @Json(name = "updated_at") val updatedAt: String?,
)