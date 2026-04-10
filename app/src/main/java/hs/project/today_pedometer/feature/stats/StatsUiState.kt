package hs.project.today_pedometer.feature.stats

import hs.project.today_pedometer.domain.model.StatisticsOverview
import hs.project.today_pedometer.domain.model.StatisticsPeriod

data class StatsUiState(
    val selectedPeriod: StatisticsPeriod = StatisticsPeriod.DAILY,
    val overview: StatisticsOverview = StatisticsOverview(),
    val isLoading: Boolean = true
)
