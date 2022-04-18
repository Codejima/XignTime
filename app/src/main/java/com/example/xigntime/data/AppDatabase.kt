package com.example.xigntime.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.xigntime.core.converter.LocalDateConverter
import com.example.xigntime.core.converter.LocalDateTimeConverter
import com.example.xigntime.data.daos.*
import com.example.xigntime.data.entities.*
import com.example.xigntime.data.entities.Target

//This database class tells Room how to define the database.
@Database(
    entities = [
        User::class,
        Profile::class,
        WorkDay::class,
        Target::class,
        WorkEntry::class,
        Notes::class,
        Category::class
    ],
    version = 1
)
@TypeConverters(LocalDateConverter::class, LocalDateTimeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun workEntryDao(): WorkEntryDao
    abstract fun profileDao(): ProfileDao
    abstract fun workDayDao(): WorkDayDao
    abstract fun targetDao(): TargetDao
    abstract fun notesDao(): NotesDao
    abstract fun categoryDao(): CategoryDao
    abstract fun userDao(): UserDao

    //TODO: which dao? every single dao? or should app-/xigntimedatabase be entrydatabase and create a database for every single dao?
    //TODO: change this dao to entry dao - add/use rest of daos in mainactivity if still necessary
/*    abstract val workEntryDao: WorkEntryDao
    abstract val userDao: UserDao
    abstract val profileDao: ProfileDao
    abstract val workDayDao: WorkDayDao
    abstract val targetDao: TargetDao
    abstract val notesDao: NotesDao
    abstract val categoryDao: CategoryDao*/

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
