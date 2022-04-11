package com.example.xigntime.data.repoImpl

import com.example.xigntime.data.daos.CategoryDao
import com.example.xigntime.data.entities.Category
import com.example.xigntime.data.repo.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(
    private val dao: CategoryDao
): CategoryRepository {

    override suspend fun insertCategory(category: Category) {
        dao.insertCategory(category)    }

    override suspend fun deleteCategory(category: Category) {
        dao.deleteCategory(category)
    }

    override suspend fun getCategoryById(categoryId: Int): Category {
        return dao.getCategoryById(categoryId)
    }

    override fun getCategory(): Flow<List<Category>> {
        return dao.getCategory()
    }
}