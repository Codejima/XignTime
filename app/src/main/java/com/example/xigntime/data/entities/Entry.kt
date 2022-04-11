package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Duration
import java.time.Instant

//This entity is the "entry" table in our database
// which contains all attributes of an entry.
@Entity
data class Entry(
    @PrimaryKey
    val entryId: Int,
    val entryTitle: String,
    val entryTimeStarted: Instant,
    val entryTimeEnded: Instant?,
    val entryTimeElapsed: Duration?,
    val workDayId: Int,
    val notesId: Int?
)