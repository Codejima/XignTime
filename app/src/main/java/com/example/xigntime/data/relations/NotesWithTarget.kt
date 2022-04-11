package com.example.xigntime.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.xigntime.data.entities.Notes
import com.example.xigntime.data.entities.Target

data class NotesWithTarget(
    @Embedded val notes: Notes,
    @Relation(
        parentColumn = "notesId",
        entityColumn = "notesId"
    )
    val targets: List<Target>
) {
}