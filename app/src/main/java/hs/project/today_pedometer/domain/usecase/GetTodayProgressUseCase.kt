package hs.project.today_pedometer.domain.usecase

import hs.project.today_pedometer.domain.repository.PedometerRepository
import javax.inject.Inject

class GetTodayProgressUseCase @Inject constructor(
    private val repository: PedometerRepository
) {
    operator fun invoke(date: String) = repository.observeDailyProgress(date)
}

