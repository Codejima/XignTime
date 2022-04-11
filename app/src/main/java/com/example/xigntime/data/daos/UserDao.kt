package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.Entry
import com.example.xigntime.data.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM User WHERE userId = :userId")
    suspend fun getUserById(userId: Int): User

    //TODO: add queries
    @Transaction
    @Query("SELECT * FROM User WHERE userName = :userName")
    suspend fun getUserWithUserName(userName: String): List<User>

    @Transaction
    @Query("SELECT * FROM User")
    fun getUser(): Flow<List<User>>


}