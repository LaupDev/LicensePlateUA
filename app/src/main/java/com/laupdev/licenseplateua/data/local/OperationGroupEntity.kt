package com.laupdev.licenseplateua.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "operations_groups")
data class OperationGroupEntity(
    @PrimaryKey
    @ColumnInfo(name = "operation_group_id")
    val operationGroupId: Int,
    @ColumnInfo(name = "name_ua")
    val nameUa: String,
    @ColumnInfo(name = "name_ru")
    val nameRu: String,
)