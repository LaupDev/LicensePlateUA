package com.laupdev.licenseplateua.data.local.entities.license_plate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "operations_notes",
    foreignKeys = [
        ForeignKey(
            entity = OperationEntity::class,
            parentColumns = ["operation_id"],
            childColumns = ["operation_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["operation_id"])]
)
data class OperationNoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "operation_note_id")
    val operationNoteId: Int = 0,
    @ColumnInfo(name = "operation_id")
    val operationId: Int,
    @ColumnInfo(name = "note_ua")
    val noteUa: String,
    @ColumnInfo(name = "note_ru")
    val noteRu: String,
)