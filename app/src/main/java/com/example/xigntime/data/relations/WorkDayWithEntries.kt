package com.example.xigntime.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.xigntime.data.entities.WorkEntry
import com.example.xigntime.data.entities.WorkDay

data class WorkDayWithEntries(
    @Embedded val workDay: WorkDay,
    @Relation(
        parentColumn = "workDayId",
        entityColumn = "workDayId"
    )
    val workEntries: List<WorkEntry>
)