package com.example.xigntime.domain.model

import java.time.LocalDate

class WorkDayDbo (
    val workDayId: Int,
    val workDayDate: LocalDate, //String, // TODO: add typeconverter for LocalDate for room
    val profileId: Int
)