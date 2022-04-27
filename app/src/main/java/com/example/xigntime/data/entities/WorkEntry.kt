package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Duration
import java.time.Instant

//This entity is the "entry" table in the database
// which contains all attributes of an entry.
@Entity
data class WorkEntry(
    @PrimaryKey
    val workEntryId: Long,
    val entryTitle: String,
    val entryTimeStarted: Long,
    val entryTimeEnded: Long?,
    val entryTimeElapsed: Long?,
    val workDayId: Long,
    val notesId: Long?
)

