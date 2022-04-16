package com.example.xigntime.core.converter

import android.provider.Settings
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

class LocalDateTimeConverter {

    @TypeConverter
    fun toDateTime(dateTimeString: String?): LocalDateTime? {
        return if (dateTimeString === null) {
            null
        } else {
            LocalDateTime.parse(dateTimeString)
        }
    }

    @TypeConverter
    fun toDateString(dateTime: LocalDateTime?): String? {
        return if (dateTime === null) {
            null
        } else {
            dateTime.toString()
        }
    }
    @TypeConverter
    fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return format.format(date)
    }
    @TypeConverter
    fun currentTimeToLong(currentTimeMillis: System): Long {
        return System.currentTimeMillis()
    }
    @TypeConverter
    fun convertDateToLong(date: String): Long {
        val df = SimpleDateFormat("yyyy.MM.dd HH:mm")
        return df.parse(date).time
    }
}