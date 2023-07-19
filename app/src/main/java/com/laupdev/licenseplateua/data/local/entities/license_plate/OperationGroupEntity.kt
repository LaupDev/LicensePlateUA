package com.laupdev.licenseplateua.data.local.entities.license_plate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "operations_groups")
// TODO: Add foreign keys
// I will cache this date in later versions of the app
data class OperationGroupEntity(
    @PrimaryKey
    @ColumnInfo(name = "operation_group_id")
    val operationGroupId: Int,
    @ColumnInfo(name = "name_ua")
    val nameUa: String,
    @ColumnInfo(name = "name_ru")
    val nameRu: String,
)