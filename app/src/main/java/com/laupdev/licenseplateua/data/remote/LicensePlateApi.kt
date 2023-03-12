package com.laupdev.licenseplateua.data.remote

import com.laupdev.licenseplateua.data.remote.dto.LicensePlateInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface LicensePlateApi {

    @GET("nomer/{license_plate}")
    suspend fun getLicensePlateInfoByLicensePlate(@Path("license_plate") licensePlate: String): LicensePlateInfoDto

    companion object {
        const val API_KEY = "959c29b95565187922755d706a1d7a56"
        const val BASE_URL = "https://baza-gai.com.ua"
    }
}