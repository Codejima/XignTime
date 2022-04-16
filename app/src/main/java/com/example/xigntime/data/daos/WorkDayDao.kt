package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.WorkDay
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkDayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkDay(workDay: WorkDay)

    @Delete
    suspend fun deleteWorkDay(workDay: WorkDay)

    //TODO: add queries and @Transaction annos where necessary

    //@Transaction
    @Query("SELECT * FROM WorkDay WHERE workDayId = :workDayId")
    suspend fun getWorkDayById(workDayId: Int): WorkDay

    //@Transaction
    @Query("SELECT * FROM WorkDay")
    fun getWorkDay(): Flow<List<WorkDay>>

    //TODO: add queries with
/*    @Transaction
    @Query("SELECT * FROM WorkDay WHERE workDayId = :workDayId")
    suspend fun getWorkDayWithEntries(workDay: WorkDay): List<WorkDayWithEntries>

    @Transaction
    @Query("SELECT * FROM WorkDay WHERE workDayId = :workDayId")
    suspend fun getWorkDayWithTargets(workDay: WorkDay): List<WorkDayWithTargets>*/
}