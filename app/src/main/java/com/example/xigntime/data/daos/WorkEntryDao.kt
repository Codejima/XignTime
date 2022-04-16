package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.WorkEntry
import kotlinx.coroutines.flow.Flow

//This Dao defines how to save data in the database (how it is accessed) and get data into room
@Dao
interface WorkEntryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(workEntry: WorkEntry)

    @Delete
    suspend fun deleteEntry(workEntry: WorkEntry)

    //TODO: add queries and @Transaction annos where necessary

    //@Transaction
    @Query("SELECT * FROM WorkEntry WHERE workEntryId = :workEntryId")
    suspend fun getEntryById(workEntryId: Long): WorkEntry

    //@Transaction
    @Query("SELECT * FROM WorkEntry")
    fun getEntry(): Flow<List<WorkEntry>>
}
