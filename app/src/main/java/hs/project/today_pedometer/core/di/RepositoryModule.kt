package hs.project.today_pedometer.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hs.project.today_pedometer.data.repository.PedometerRepositoryImpl
import hs.project.today_pedometer.data.repository.SettingsRepositoryImpl
import hs.project.today_pedometer.domain.repository.PedometerRepository
import hs.project.today_pedometer.domain.repository.SettingsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPedometerRepository(
        repositoryImpl: PedometerRepositoryImpl
    ): PedometerRepository

    @Binds
    @Singleton
    abstract fun bindSettingsRepository(
        repositoryImpl: SettingsRepositoryImpl
    ): SettingsRepository
}

