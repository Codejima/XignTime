package com.example.xigntime.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.xigntime.data.entities.Category
import com.example.xigntime.data.entities.Target

data class CategoryWithTarget(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryId"
    )
    val targets: List<Target>
)