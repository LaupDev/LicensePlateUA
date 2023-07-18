package com.laupdev.licenseplateua.data.local.entities.license_plate

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// TODO: Create database and connect all tables

@Entity(
    tableName = "license_plates",
    indices = [
        Index(value = ["digits"], unique = true),
        Index(value = ["vin"], unique = true)
    ]
)
data class LicensePlateInfoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "license_plate_id")
    val licensePlateId: Int = 0,
    @ColumnInfo(name = "digits")
    val plateNumber: String,
    @ColumnInfo(name = "vin")
    val vin: String,
    @ColumnInfo(name = "car_vendor")
    val carVendor: String,
    @ColumnInfo(name = "car_model")
    val carModel: String,
    @ColumnInfo(name = "car_model_year")
    val carModelYear: Int,
    @ColumnInfo(name = "car_photo_url")
    val carPhotoUrl: String,
    @ColumnInfo(name = "is_stolen")
    val isCarStolen: Boolean,
//    @ColumnInfo(name = "stolen_details")
//    val stolenDetails: Any, // TODO: Add stolenDetails
    @ColumnInfo(name = "region_id")
    val regionId: Int
)