package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.WorkEntryDao
import com.example.xigntime.data.entities.WorkEntry
import com.example.xigntime.data.repo.EntryRepository
import kotlinx.coroutines.flow.Flow

//This class implements the repositories by calling the DAOs corresponding functions
class EntryRepositoryImpl(
    private val workEntryDao: WorkEntryDao
): EntryRepository{

    override suspend fun insertEntry(workEntry: WorkEntry) {
        workEntryDao.insertEntry(workEntry)    }

    override suspend fun deleteEntry(workEntry: WorkEntry) {
        workEntryDao.deleteEntry(workEntry)
    }

    override suspend fun getEntryById(workEntryId: Long): WorkEntry {
        return workEntryDao.getEntryById(workEntryId)
    }

    override fun getEntry(): Flow<List<WorkEntry>> {
        return workEntryDao.getEntry()
    }
}