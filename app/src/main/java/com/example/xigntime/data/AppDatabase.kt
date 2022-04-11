package com.example.xigntime.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xigntime.data.daos.*
import com.example.xigntime.data.entities.*

//This database class tells Room how to define the database.
@Database(
    entities = [
        User::class,
        Profile::class,
        WorkDay::class,
        TargetDao::class,
        Entry::class,
        Notes::class,
        Category::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun entryDao(): EntryDao
    abstract fun userDao(): UserDao
    abstract fun profileDao(): ProfileDao
    abstract fun workDayDao(): WorkDayDao
    abstract fun targetDao(): TargetDao
    abstract fun notesDao(): NotesDao
    abstract fun categoryDao(): CategoryDao

    //TODO: which dao? every single dao? or should app-/xigntimedatabase be entrydatabase and create a database for every single dao?

    //TODO: change this dao to entry dao - add/use rest of daos in mainactivity if still necessary
    abstract val dao: EntryDao

    abstract val userDao: UserDao
    abstract val profileDao: ProfileDao
    abstract val workDayDao: WorkDayDao
    abstract val targetDao: TargetDao
    abstract val notesDao: NotesDao
    abstract val categoryDao: CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "xign_time_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}

/*
class LocalDateConverter() {

    fun FromLocalDateToString() {

    }
}*/
