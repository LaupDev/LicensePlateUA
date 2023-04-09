package com.laupdev.licenseplateua.di

import com.laupdev.licenseplateua.domain.usecases.GetLicensePlateInfoUseCase
import com.laupdev.licenseplateua.domain.usecases.GetLicensePlateInfoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCasesModule {

    @Singleton
    @Binds
    abstract fun bindGetLicensePlateInfoUseCase(
        getLicensePlateInfoUseCaseImpl: GetLicensePlateInfoUseCaseImpl
    ): GetLicensePlateInfoUseCase
}