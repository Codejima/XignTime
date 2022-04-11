package com.example.xigntime.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.xigntime.data.entities.Entry
import com.example.xigntime.data.entities.Notes

data class NotesWithEntry(
    @Embedded val notes: Notes,
    @Relation(
        parentColumn = "notesId",
        entityColumn = "notesId"
    )
    val entries: List<Entry>
) {
}