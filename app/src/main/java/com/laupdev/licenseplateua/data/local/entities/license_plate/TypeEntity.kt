package com.laupdev.licenseplateua.data.local.entities.license_plate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "regions")
data class TypeEntity(
    @PrimaryKey
    @ColumnInfo(name = "type_id")
    val typeId: Int,
    @ColumnInfo(name = "name_ua")
    val nameUa: String,
    @ColumnInfo(name = "name_ru")
    val nameRu: String,
    @ColumnInfo(name = "slug")
    val slug: String,
)