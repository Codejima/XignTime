package com.example.xigntime.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey
    val categoryId: Int,
    val categoryTag: Int,
    val categoryPriority: Int
) {
}