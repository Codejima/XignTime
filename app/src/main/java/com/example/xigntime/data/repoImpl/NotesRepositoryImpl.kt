package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.NotesDao
import com.example.xigntime.data.daos.WorkDayDao
import com.example.xigntime.data.entities.Notes
import com.example.xigntime.data.entities.WorkDay
import com.example.xigntime.data.repo.NotesRepository
import com.example.xigntime.data.repo.WorkDayRepository
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(
    private val dao: NotesDao
): NotesRepository {

    override suspend fun insertNotes(notes: Notes) {
        dao.insertNotes(notes)    }

    override suspend fun deleteNotes(notes: Notes) {
        dao.deleteNotes(notes)
    }

    override suspend fun getNotesById(notesId: Int): Notes {
        return dao.getNotesById(notesId)
    }

    override fun getNotes(): Flow<List<Notes>> {
        return dao.getNotes()
    }
}