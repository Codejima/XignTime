package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.Target
import kotlinx.coroutines.flow.Flow

interface TargetRepository {

    suspend fun insertTarget(target: Target)

    suspend fun deleteTarget(target: Target)

    suspend fun getTargetById(targetId: Int): Target

    fun getTarget(): Flow<List<Target>>
}