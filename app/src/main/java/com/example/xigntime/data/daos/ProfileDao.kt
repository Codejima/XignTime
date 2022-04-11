package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.Category
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.relations.ProfileWithWorkDays
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: Profile)

    @Delete
    suspend fun deleteProfile(profile: Profile)

    //TODO: add queries and @Transaction annos where necessary

    //@Transaction
    @Query("SELECT * FROM Profile WHERE profileId = :profileId")
    suspend fun getProfileById(profileId: Int): Profile

    //@Transaction
    @Query("SELECT * FROM Profile")
    fun getProfile(): Flow<List<Profile>>

    //TODO: add queries

    @Transaction
    @Query("SELECT * FROM Profile WHERE profileName = :profileName")
    suspend fun getProfilesWithWorkDays(profileName: String): List<ProfileWithWorkDays>

}