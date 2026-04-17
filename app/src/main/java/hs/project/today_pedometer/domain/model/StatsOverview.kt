package hs.project.today_pedometer.domain.model

data class StatsOverview(
    val summary: StatsSummary = StatsSummary(),
    val records: List<StatsRecord> = emptyList()
)

