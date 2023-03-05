package com.laupdev.licenseplateua.domain.model


data class Comment(
    val id: Int,
    val userName: String,
    val text: String,
    val createdAt: String,
    val updatedAt: String,
)