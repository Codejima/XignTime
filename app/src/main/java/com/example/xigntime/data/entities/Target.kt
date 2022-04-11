package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Time

@Entity
data class Target(
    @PrimaryKey
    val targetId: Int,
    val targetHours: Time,
    val workDayId: Int,
    val categoryId: Int,
    val notesId: Int
)