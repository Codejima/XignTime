package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.WorkDay
import kotlinx.coroutines.flow.Flow

interface WorkDayRepository {

    suspend fun insertWorkDay(workDay: WorkDay)

    suspend fun deleteWorkDay(workDay: WorkDay)

    suspend fun getWorkDayById(workDayId: Int): WorkDay

    fun getWorkDay(): Flow<List<WorkDay>>
}