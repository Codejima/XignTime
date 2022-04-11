package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.Entry
import kotlinx.coroutines.flow.Flow

//This Dao defines how the database is accessed and what happens (queries)
@Dao
interface EntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(entry: Entry)

    @Delete
    suspend fun deleteEntry(entry: Entry)

    //TODO: add queries and @Transaction annos where necessary

    //@Transaction
    @Query("SELECT * FROM Entry WHERE entryId = :entryId")
    suspend fun getEntryById(entryId: Int): Entry

    //@Transaction
    @Query("SELECT * FROM Entry")
    fun getEntry(): Flow<List<Entry>>
}
