package com.example.xigntime.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.entities.User

data class UserWithProfiles(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )
    val profiles: List<Profile>
)