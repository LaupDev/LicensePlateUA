package com.laupdev.licenseplateua.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "regions",
    indices = [
        Index(value = ["new_code"], unique = true)
    ]
)
data class RegionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "region_id")
    val regionId: Int = 0,
    @ColumnInfo(name = "name_ua")
    val nameUa: String,
    @ColumnInfo(name = "name_ru")
    val nameRu: String,
    @ColumnInfo(name = "new_code")
    val newCode: String,
    @ColumnInfo(name = "old_code")
    val oldCode: String,
    @ColumnInfo(name = "slug")
    val slug: String,
)