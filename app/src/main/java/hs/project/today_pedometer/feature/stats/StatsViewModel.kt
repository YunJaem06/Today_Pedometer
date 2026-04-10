package hs.project.today_pedometer.feature.stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hs.project.today_pedometer.domain.model.StatisticsPeriod
import hs.project.today_pedometer.domain.usecase.ObserveStatisticsOverviewUseCase
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class StatsViewModel @Inject constructor(
    private val observeStatisticsOverviewUseCase: ObserveStatisticsOverviewUseCase
) : ViewModel() {

    private val selectedPeriod = MutableStateFlow(StatisticsPeriod.DAILY)
    private val _uiState = MutableStateFlow(StatsUiState())
    val uiState: StateFlow<StatsUiState> = _uiState.asStateFlow()

    init {
        observeStatistics()
    }

    fun onPeriodSelected(period: StatisticsPeriod) {
        if (selectedPeriod.value == period) return
        _uiState.update { it.copy(selectedPeriod = period, isLoading = true) }
        selectedPeriod.value = period
    }

    private fun observeStatistics() {
        viewModelScope.launch {
            selectedPeriod
                .flatMapLatest { period ->
                    observeStatisticsOverviewUseCase(period).map { period to it }
                }
                .collect { (period, overview) ->
                    _uiState.update {
                        it.copy(
                            selectedPeriod = period,
                            overview = overview,
                            isLoading = false
                        )
                    }
                }
        }
    }
}
