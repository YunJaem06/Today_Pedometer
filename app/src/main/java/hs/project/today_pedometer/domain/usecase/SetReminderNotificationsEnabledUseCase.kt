package hs.project.today_pedometer.domain.usecase

import hs.project.today_pedometer.domain.repository.SettingsRepository
import javax.inject.Inject

class SetReminderNotificationsEnabledUseCase @Inject constructor(
    private val repository: SettingsRepository
) {
    suspend operator fun invoke(enabled: Boolean) {
        repository.updateReminderNotificationsEnabled(enabled)
    }
}

