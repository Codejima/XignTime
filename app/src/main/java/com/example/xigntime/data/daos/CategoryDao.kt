package com.example.xigntime.data.daos

import androidx.room.*
import com.example.xigntime.data.entities.Category
import com.example.xigntime.data.entities.Entry
import com.example.xigntime.data.relations.CategoryWithTarget
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)

    //TODO: add queries and @Transaction annos where necessary

    //@Transaction
    @Query("SELECT * FROM Category WHERE categoryId = :categoryId")
    suspend fun getCategoryById(categoryId: Int): Category

    //@Transaction
    @Query("SELECT * FROM Category")
    fun getCategory(): Flow<List<Category>>

    //TODO: add queries with @Query
    @Transaction
    @Query("SELECT * FROM Category WHERE categoryId = :category")
    suspend fun getCategoryWithTarget(category: Category): List<CategoryWithTarget>
}