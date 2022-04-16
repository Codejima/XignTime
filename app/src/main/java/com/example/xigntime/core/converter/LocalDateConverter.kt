package com.example.xigntime.core.converter

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime


class LocalDateConverter {

    @TypeConverter
    fun toDate(dateString: String?): LocalDate? {
        return if (dateString === null) {
            null
        } else {
            LocalDate.parse(dateString)
        }
    }

    @TypeConverter
    fun toDateString(date: LocalDate?): String? {
        return if (date === null) {
            null
        } else {
            date.toString()
        }
    }
}