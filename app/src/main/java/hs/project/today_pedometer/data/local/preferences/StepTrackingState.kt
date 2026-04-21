package hs.project.today_pedometer.data.local.preferences

data class StepTrackingState(
    val trackingDate: String? = null,
    val baselineSensorSteps: Int? = null,
    val offsetSteps: Int = 0
)
