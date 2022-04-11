package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.UserDao
import com.example.xigntime.data.entities.User
import com.example.xigntime.data.repo.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(
    private val dao: UserDao
): UserRepository {

    override suspend fun insertUser(user: User) {
        dao.insertUser(user)    }

    override suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }

    override suspend fun getUserById(userId: Int): User {
        return dao.getUserById(userId)
    }

    override fun getUser(): Flow<List<User>> {
        return dao.getUser()
    }
}
