package com.laupdev.licenseplateua.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class CommentEntity(
    @PrimaryKey
    @ColumnInfo(name = "comment_id")
    val commentId: Int,
    @ColumnInfo(name = "license_plate_id")
    val licensePlateId: Int,
    @ColumnInfo(name = "username")
    val userName: String,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "created_at")
    val createdAt: String,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
)