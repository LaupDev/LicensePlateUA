package com.laupdev.licenseplateua.di

import com.laupdev.licenseplateua.data.repository.LicensePlateRepositoryImpl
import com.laupdev.licenseplateua.domain.repository.LicensePlateRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindLicensePlateRepository(
        licensePlateRepositoryImpl: LicensePlateRepositoryImpl
    ): LicensePlateRepository

}