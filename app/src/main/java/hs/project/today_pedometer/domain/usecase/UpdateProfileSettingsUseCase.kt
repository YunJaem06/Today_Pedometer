package hs.project.today_pedometer.domain.usecase

import hs.project.today_pedometer.domain.repository.SettingsRepository
import javax.inject.Inject

class UpdateProfileSettingsUseCase @Inject constructor(
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(
        dailyGoal: Int,
        stepLengthCm: Int,
        heightCm: Int,
        weightKg: Int
    ) {
        repository.updateProfileSettings(
            dailyGoal = dailyGoal,
            stepLengthCm = stepLengthCm,
            heightCm = heightCm,
            weightKg = weightKg
        )
    }
}

