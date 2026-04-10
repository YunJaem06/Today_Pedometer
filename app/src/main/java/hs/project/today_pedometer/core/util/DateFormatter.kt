package hs.project.today_pedometer.core.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateFormatter {
    private val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)

    fun today(): String = formatter.format(Date())
}

