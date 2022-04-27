package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Profile(
    @PrimaryKey
    val profileId: Int,
    val profileName: String,
    val userId: Int
)