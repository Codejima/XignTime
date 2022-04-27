package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
    @PrimaryKey
    val notesId: Int,
    val notesNote: String
)