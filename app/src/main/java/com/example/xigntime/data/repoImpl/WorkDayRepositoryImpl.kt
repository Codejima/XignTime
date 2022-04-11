package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.TargetDao
import com.example.xigntime.data.daos.WorkDayDao
import com.example.xigntime.data.entities.Target
import com.example.xigntime.data.entities.WorkDay
import com.example.xigntime.data.repo.TargetRepository
import com.example.xigntime.data.repo.WorkDayRepository
import kotlinx.coroutines.flow.Flow

class WorkDayRepositoryImpl(
    private val dao: WorkDayDao
): WorkDayRepository {

    override suspend fun insertWorkDay(workDay: WorkDay) {
        dao.insertWorkDay(workDay)    }

    override suspend fun deleteWorkDay(workDay: WorkDay) {
        dao.deleteWorkDay(workDay)
    }

    override suspend fun getWorkDayById(workDayId: Int): WorkDay {
        return dao.getWorkDayById(workDayId)
    }

    override fun getWorkDay(): Flow<List<WorkDay>> {
        return dao.getWorkDay()
    }
}