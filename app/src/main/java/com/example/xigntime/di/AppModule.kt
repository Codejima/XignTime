package com.example.xigntime.di

import android.app.Application
import androidx.room.Room
import com.example.xigntime.data.AppDatabase
import com.example.xigntime.data.repo.*
import com.example.xigntime.data.repoImpl.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Providing all dependencies and objects to be able to injected into the code
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            "xigntime_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideEntryRepository(db: AppDatabase): EntryRepository {
        return EntryRepositoryImpl(db.workEntryDao())
    }

    @Provides
    @Singleton
    fun provideUserRepository(db: AppDatabase): UserRepository {
        return UserRepositoryImpl(db.userDao())
    }
    @Provides
    @Singleton
    fun provideProfileRepository(db: AppDatabase): ProfileRepository {
        return ProfileRepositoryImpl(db.profileDao())
    }
    @Provides
    @Singleton
    fun provideWorkDayRepository(db: AppDatabase): WorkDayRepository {
        return WorkDayRepositoryImpl(db.workDayDao())
    }
    @Provides
    @Singleton
    fun provideTargetRepository(db: AppDatabase): TargetRepository {
        return TargetRepositoryImpl(db.targetDao())
    }
    @Provides
    @Singleton
    fun provideNotesRepository(db: AppDatabase): NotesRepository {
        return NotesRepositoryImpl(db.notesDao())
    }
    @Provides
    @Singleton
    fun provideCategoryRepository(db: AppDatabase): CategoryRepository {
        return CategoryRepositoryImpl(db.categoryDao())
    }
}