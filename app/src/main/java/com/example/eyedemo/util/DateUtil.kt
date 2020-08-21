package com.example.eyedemo.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {

    const val MINUTE = (60 * 1000).toLong()

    const val HOUR = 60 * MINUTE

    const val DAY = 24 * HOUR

    const val WEEK = 7 * DAY

    const val MONTH = 4 * WEEK

    const val YEAR = 365 * DAY

    fun getConvertedDate(dateMillis: Long): String {
        val currentMillis = System.currentTimeMillis()
        val timePast = currentMillis - dateMillis
        if (timePast > -MINUTE) {
            when {
                timePast < DAY -> {
                    var pastHours = timePast / HOUR
                    if (pastHours <= 0) {
                        pastHours = 1
                    }
                    return getDateAndHourMinuteTime(dateMillis)
                }
                timePast < WEEK -> {
                    var pastDays = timePast / DAY
                    if (pastDays <= 0) {
                        pastDays = 1
                    }
                    return "$pastDays 天前"
                }
                timePast < MONTH -> {
                    var pastDays = timePast / WEEK
                    if (pastDays <= 0) {
                        pastDays = 1
                    }
                    return "$pastDays 周前"
                }
                else -> return getDate(dateMillis)
            }
        } else {
            return getDateAndTime(dateMillis)
        }
    }

    fun getDate(dateMillis: Long, pattern: String = "yyyy-MM-dd"): String {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        return sdf.format(Date(dateMillis))
    }

    private fun getDateAndTime(dateMillis: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        return sdf.format(Date(dateMillis))
    }

    private fun getDateAndHourMinuteTime(dateMillis: Long): String {
        val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
        return sdf.format(Date(dateMillis))
    }
}