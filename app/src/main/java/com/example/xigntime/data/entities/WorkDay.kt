package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
data class WorkDay(
    @PrimaryKey
    val workDayId: Int,
    val workDayDate: String, // TODO: add typeconverter for LocalDate for room
    val profileId: Int
)