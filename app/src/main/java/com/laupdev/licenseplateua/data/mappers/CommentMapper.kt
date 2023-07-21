package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.remote.dto.CommentDto
import com.laupdev.licenseplateua.domain.model.Comment

fun CommentDto.toComment(): Comment =
    Comment(
        userName = userName ?: "",
        text = text ?: "",
        createdAt = createdAt ?: "",
        updatedAt = updatedAt ?: "",
    )