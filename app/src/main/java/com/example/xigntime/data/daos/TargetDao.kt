package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.entities.Target
import kotlinx.coroutines.flow.Flow

@Dao
interface TargetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTarget(target: Target)

    @Delete
    suspend fun deleteTarget(target: Target)

    //TODO: add queries and @Transaction annos where necessary

    //@Transaction
    @Query("SELECT * FROM Target WHERE targetId = :targetId")
    suspend fun getTargetById(targetId: Int): Target

    //@Transaction
    @Query("SELECT * FROM Target")
    fun getTarget(): Flow<List<Target>>

    //TODO: add queries
/*    @Transaction
    @Query("SELECT * FROM Target WHERE targetId = :target")
    suspend fun getTargetIdWithUserName(target: Target): List<Target>*/
}