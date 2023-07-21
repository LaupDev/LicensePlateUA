package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class CommentDto(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "name") val userName: String?,
    @field:Json(name = "text") val text: String?,
    @field:Json(name = "created_at") val createdAt: String?,
    @field:Json(name = "updated_at") val updatedAt: String?,
)