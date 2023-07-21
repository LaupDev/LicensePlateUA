package com.laupdev.licenseplateua.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laupdev.licenseplateua.data.local.entities.license_plate.*

@Database(
    entities = [
        LicensePlateMainInfoEntity::class
    ],
    version = 1
)
abstract class LicensePlatesDatabase : RoomDatabase() {
    abstract fun licensePlatesDao(): LicensePlatesDao
}