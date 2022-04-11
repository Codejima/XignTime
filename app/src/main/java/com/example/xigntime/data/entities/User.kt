package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Blob

@Entity
data class User(
    @PrimaryKey
    val userId: Int,
    val userName: String,
    val userPassword: String,
    val userSalt: ByteArray //TODO: look up room blob
)