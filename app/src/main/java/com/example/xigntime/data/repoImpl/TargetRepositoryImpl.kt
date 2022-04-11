package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.TargetDao
import com.example.xigntime.data.repo.TargetRepository
import com.example.xigntime.data.entities.Target
import kotlinx.coroutines.flow.Flow

class TargetRepositoryImpl(
    private val dao: TargetDao
): TargetRepository {

    override suspend fun insertTarget(target: Target) {
        dao.insertTarget(target)    }

    override suspend fun deleteTarget(target: Target) {
        dao.deleteTarget(target)
    }

    override suspend fun getTargetById(targetId: Int): Target {
        return dao.getTargetById(targetId)
    }

    override fun getTarget(): Flow<List<Target>> {
        return dao.getTarget()
    }
}