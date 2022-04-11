package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.Profile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    suspend fun insertProfile(profile: Profile)

    suspend fun deleteProfile(profile: Profile)

    suspend fun getProfileById(profileId: Int): Profile

    fun getUser(): Flow<List<Profile>>
}