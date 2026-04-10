package hs.project.today_pedometer.feature.splash

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hs.project.today_pedometer.domain.usecase.ObserveUserPreferencesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    observeUserPreferencesUseCase: ObserveUserPreferencesUseCase
) : ViewModel() {

    val onboardingCompleted: Flow<Boolean> = observeUserPreferencesUseCase()
        .map { it.onboardingCompleted }
}
