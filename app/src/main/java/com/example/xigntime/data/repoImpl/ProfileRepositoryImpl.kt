package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.ProfileDao
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.repo.ProfileRepository
import kotlinx.coroutines.flow.Flow

class ProfileRepositoryImpl(
    private val dao: ProfileDao
): ProfileRepository {

    override suspend fun insertProfile(profile: Profile) {
        dao.insertProfile(profile)    }

    override suspend fun deleteProfile(profile: Profile) {
        dao.deleteProfile(profile)
    }

    override suspend fun getProfileById(profileId: Int): Profile {
        return dao.getProfileById(profileId)
    }

    override fun getProfile(): Flow<List<Profile>> {
        return dao.getProfile()
    }
}