package com.example.xigntime.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.entities.WorkDay

data class ProfileWithWorkDays(
    @Embedded val profile: Profile,
    @Relation(
        parentColumn = "profileId",
        entityColumn = "profileId"
    )
    val workDays: List<WorkDay>
    )

