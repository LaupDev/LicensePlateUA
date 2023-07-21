package com.laupdev.licenseplateua.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laupdev.licenseplateua.data.local.entities.license_plate.LicensePlateMainInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LicensePlatesDao {

    @Query("SELECT * FROM license_plates")
    fun getAllLicensePlates(): Flow<List<LicensePlateMainInfoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLicensePlate(licensePlateInfo: LicensePlateMainInfoEntity)

    @Query("DELETE FROM license_plates")
    fun deleteAllLicensePlates()
}