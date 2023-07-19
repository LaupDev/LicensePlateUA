package com.laupdev.licenseplateua.data.local.entities.license_plate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Operations",
    foreignKeys = [
        ForeignKey(
            entity = LicensePlateInfoEntity::class,
            parentColumns = ["license_plate_id"],
            childColumns = ["license_plate_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = OperationGroupEntity::class,
            parentColumns = ["operation_group_id"],
            childColumns = ["operation_group_id"]
        ),
        ForeignKey(
            entity = TypeEntity::class,
            parentColumns = ["type_id"],
            childColumns = ["type_id"]
        ),
        ForeignKey(
            entity = ColorEntity::class,
            parentColumns = ["color_id"],
            childColumns = ["color_id"]
        )
    ],
    indices = [
        Index(value = ["license_plate_id"]),
        Index(value = ["operation_group_id"]),
        Index(value = ["type_id"]),
        Index(value = ["color_id"]),
    ]
)
data class OperationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "operation_id")
    val operationId: Int = 0,
    @ColumnInfo(name = "address")
    val address: String,
    @ColumnInfo(name = "department")
    val department: String,
    @ColumnInfo(name = "is_last")
    val isLast: Boolean,
    @ColumnInfo(name = "is_registered_to_company")
    val isRegisteredToCompany: Boolean,
    @ColumnInfo(name = "koatuu")
    val koatuu: Long,
    @ColumnInfo(name = "model")
    val carModel: String,
    @ColumnInfo(name = "model_year")
    val carModelYear: Int,
    @ColumnInfo(name = "registered_at")
    val registeredAt: String,
    @ColumnInfo(name = "vendor")
    val carVendor: String,
    @ColumnInfo(name = "vendor_slug")
    val carVendorSlug: String,
    @ColumnInfo(name = "license_plate_id")
    val licensePlateId: Int,
    @ColumnInfo(name = "color_id")
    val colorId: Int,
    @ColumnInfo(name = "type_id")
    val typeId: Int,
    @ColumnInfo(name = "operation_group_id")
    val operationGroupId: Int,
)