package hs.project.today_pedometer.feature.progress

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hs.project.today_pedometer.core.util.DateFormatter
import hs.project.today_pedometer.domain.usecase.GetTodayProgressUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgressViewModel @Inject constructor(
    private val getTodayProgressUseCase: GetTodayProgressUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProgressUiState())
    val uiState: StateFlow<ProgressUiState> = _uiState.asStateFlow()

    init {
        observeTodayProgress()
    }

    private fun observeTodayProgress() {
        val today = DateFormatter.today()
        viewModelScope.launch {
            getTodayProgressUseCase(today).collect { progress ->
                _uiState.update {
                    it.copy(
                        date = progress.date,
                        steps = progress.steps,
                        goal = progress.goal,
                        distanceMeters = progress.distanceMeters,
                        calories = progress.calories,
                        isLoading = false
                    )
                }
            }
        }
    }
}
