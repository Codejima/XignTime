package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.WorkEntry
import kotlinx.coroutines.flow.Flow

//This repository interface holds the same functions as the DAO.
//Accesses the different data sources (database, API...).
//Not necessary for this project.
//Makes API integration possible/easier with an expanding/bigger project.
interface EntryRepository {

    suspend fun insertEntry(workEntry: WorkEntry)

    suspend fun deleteEntry(workEntry: WorkEntry)

    suspend fun getEntryById(workEntryId: Long): WorkEntry

    fun getEntry(): Flow<List<WorkEntry>>
}