package com.laupdev.licenseplateua.data.local.entities.license_plate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "colors",
    indices = [
        Index(value = ["name_slug"], unique = true)
    ]
)
// TODO: Add foreign keys
// I will cache this date in later versions of the app
data class ColorEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "color_id")
    val colorId: Int = 0,
    @ColumnInfo(name = "name_slug")
    val nameSlug: String,
    @ColumnInfo(name = "name_ua")
    val nameUa: String,
    @ColumnInfo(name = "name_ru")
    val nameRu: String,
)