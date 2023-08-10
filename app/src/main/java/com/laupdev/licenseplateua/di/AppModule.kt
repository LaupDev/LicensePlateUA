package com.laupdev.licenseplateua.di

import android.content.Context
import androidx.room.Room
import com.laupdev.licenseplateua.data.local.LicensePlatesDatabase
import com.laupdev.licenseplateua.data.remote.LicensePlateApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLicensePlateApi(): LicensePlateApi {
        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().let { original ->
                original.newBuilder()
                    .header("X-Api-Key", LicensePlateApi.API_KEY)
                    .header("Accept", "application/json\\r\\n")
                    .method(original.method, original.body)
                    .build()
            }
            chain.proceed(request)
        }.build()

        return Retrofit.Builder()
            .baseUrl(LicensePlateApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideLicensePlatesDatabase(@ApplicationContext context: Context): LicensePlatesDatabase {
        return Room.databaseBuilder(
            context,
            LicensePlatesDatabase::class.java,
            "license_plates_db"
        ).build()
    }

}