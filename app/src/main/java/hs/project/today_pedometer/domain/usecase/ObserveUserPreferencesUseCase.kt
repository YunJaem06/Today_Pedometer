package hs.project.today_pedometer.domain.usecase

import hs.project.today_pedometer.domain.repository.SettingsRepository
import javax.inject.Inject

class ObserveUserPreferencesUseCase @Inject constructor(
    private val repository: SettingsRepository
) {
    operator fun invoke() = repository.observePreferences()
}

