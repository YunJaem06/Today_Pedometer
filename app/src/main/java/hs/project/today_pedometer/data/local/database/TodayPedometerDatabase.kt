package hs.project.today_pedometer.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [DayRecordEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TodayPedometerDatabase : RoomDatabase() {

    abstract fun dayRecordDao(): DayRecordDao

    companion object {
        const val DATABASE_NAME = "today_pedometer.db"
    }
}

