package hs.project.today_pedometer.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hs.project.today_pedometer.data.local.database.DayRecordDao
import hs.project.today_pedometer.data.local.database.TodayPedometerDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTodayPedometerDatabase(
        @ApplicationContext context: Context
    ): TodayPedometerDatabase {
        return Room.databaseBuilder(
            context,
            TodayPedometerDatabase::class.java,
            TodayPedometerDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideDayRecordDao(database: TodayPedometerDatabase): DayRecordDao = database.dayRecordDao()
}

