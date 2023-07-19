package com.laupdev.licenseplateua.data.local.entities.license_plate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "comments"
)
// TODO: Add foreign keys
// I will cache this date in later versions of the app
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