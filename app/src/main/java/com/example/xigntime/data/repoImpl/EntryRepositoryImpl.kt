package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.EntryDao
import com.example.xigntime.data.entities.Entry
import com.example.xigntime.data.repo.EntryRepository
import kotlinx.coroutines.flow.Flow

//This class implements the repositories by calling the DAOs corresponding functions
class EntryRepositoryImpl(
    private val dao: EntryDao
): EntryRepository{

    override suspend fun insertEntry(entry: Entry) {
        dao.insertEntry(entry)    }

    override suspend fun deleteEntry(entry: Entry) {
        dao.deleteEntry(entry)
    }

    override suspend fun getEntryById(entryId: Int): Entry {
        return dao.getEntryById(entryId)
    }

    override fun getEntry(): Flow<List<Entry>> {
        return dao.getEntry()
    }
}