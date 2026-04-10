package hs.project.today_pedometer.feature.stats

import hs.project.today_pedometer.domain.model.StatsOverview
import hs.project.today_pedometer.domain.model.StatsPeriod

data class StatsUiState(
    val selectedPeriod: StatsPeriod = StatsPeriod.DAILY,
    val overview: StatsOverview = StatsOverview(),
    val isLoading: Boolean = true
)



