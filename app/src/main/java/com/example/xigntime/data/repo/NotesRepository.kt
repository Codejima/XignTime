package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.Notes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    suspend fun insertNotes(notes: Notes)

    suspend fun deleteNotes(notes: Notes)

    suspend fun getNotesById(notesId: Int): Notes

    fun getNotes(): Flow<List<Notes>>
}