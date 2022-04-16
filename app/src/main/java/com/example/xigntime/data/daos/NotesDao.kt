package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.Notes
import com.example.xigntime.data.entities.Target
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(notes: Notes)

    @Delete
    suspend fun deleteNotes(notes: Notes)

    //TODO: add queries and @Transaction annos where necessary

    //@Transaction
    @Query("SELECT * FROM Notes WHERE notesId = :notesId")
    suspend fun getNotesById(notesId: Int): Notes

    //@Transaction
    @Query("SELECT * FROM Notes")
    fun getNotes(): Flow<List<Notes>>

    //TODO: add queries
/*    @Transaction
    @Query("SELECT * FROM Notes WHERE notesId = :notesId")
    suspend fun getNotesWithEntry(notesId: Notes): List<WorkEntryDao>*/

/*    @Transaction
    @Query("SELECT * FROM Notes WHERE notesId = :notesId")
    suspend fun getNotesWithTarget(notesId: Notes): List<Target>*/
}