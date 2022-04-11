package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.Entry
import kotlinx.coroutines.flow.Flow

//This repository interface holds the same functions as the DAO.
//Accesses the different data sources (database, API...).
//Not necessary for this project.
//Makes API integration possible/easier with an expanding/bigger project.
interface EntryRepository {

    suspend fun insertEntry(entry: Entry)

    suspend fun deleteEntry(entry: Entry)

    suspend fun getEntryById(entryId: Int): Entry

    fun getEntry(): Flow<List<Entry>>
}