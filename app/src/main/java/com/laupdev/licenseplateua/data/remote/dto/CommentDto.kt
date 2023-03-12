package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.Comment
import com.squareup.moshi.Json

data class CommentDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val userName: String?,
    @Json(name = "text") val text: String?,
    @Json(name = "created_at") val createdAt: String?,
    @Json(name = "updated_at") val updatedAt: String?,
) {
    fun toComment(): Comment =
        Comment(
            userName = userName ?: "",
            text = text ?: "",
            createdAt = createdAt ?: "",
            updatedAt = updatedAt ?: "",
        )
}