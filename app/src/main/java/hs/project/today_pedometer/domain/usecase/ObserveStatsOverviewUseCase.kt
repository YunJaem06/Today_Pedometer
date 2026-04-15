package hs.project.today_pedometer.domain.usecase

import hs.project.today_pedometer.core.util.StatsDateUtils
import hs.project.today_pedometer.domain.model.StatsOverview
import hs.project.today_pedometer.domain.model.StatsPeriod
import hs.project.today_pedometer.domain.repository.PedometerRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ObserveStatsOverviewUseCase @Inject constructor(
    private val repository: PedometerRepository
) {
    operator fun invoke(period: StatsPeriod): Flow<StatsOverview> {
        val (startDate, endDate) = StatsDateUtils.queryRange(period)
        return repository.observeDailyProgressRange(startDate, endDate)
            .map { records ->
                StatsDateUtils.buildOverview(period, records)
            }
    }
}

