package com.example.xigntime.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.xigntime.data.entities.Target
import com.example.xigntime.data.entities.WorkDay

data class WorkDayWithTargets(
    @Embedded val workDay: WorkDay,
    @Relation(
        parentColumn = "workDayId",
        entityColumn = "workDayId"
    )
    val targets: List<Target>
) {
}