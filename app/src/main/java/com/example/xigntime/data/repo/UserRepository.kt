package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun insertUser(user: User)

    suspend fun deleteUser(user: User)

    suspend fun getUserById(userId: Int): User

    fun getUser(): Flow<List<User>>
}