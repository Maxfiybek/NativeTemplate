package com.example.base.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data object DateConverter {
    private const val DATE_FORMAT = "dd/MM/yyyy"

    fun millisToDate(millis: Long, dateFormat: String = DATE_FORMAT): String {
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
        return sdf.format(Date(millis))
    }

    fun dateToMillis(dateString: String, dateFormat: String = DATE_FORMAT): Long {
        val sdf = SimpleDateFormat(dateFormat, Locale.getDefault())
        return sdf.parse(dateString)?.time ?: 0L
    }
}