package com.example.xigntime.data.repo

import com.example.xigntime.data.entities.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    suspend fun insertCategory(category: Category)

    suspend fun deleteCategory(category: Category)

    suspend fun getCategoryById(categoryId: Int): Category

    fun getCategory(): Flow<List<Category>>
}