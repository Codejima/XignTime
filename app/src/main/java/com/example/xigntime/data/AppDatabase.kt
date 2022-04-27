package com.example.xigntime.data

import android.app.Application
import android.content.Context
import androidx.annotation.WorkerThread
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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
        const val NAME = "xign_time_db"

/*        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    NAME
                ).build().also {
                    INSTANCE = it
                }
            }
        }*/

        @Volatile
        private var nullableInstance: MutableState<AppDatabase?> = mutableStateOf(null)
        val instance get() = nullableInstance.value ?: error("Database has not been initialised")
        val isInitialised get() = nullableInstance.value != null
        
        /**
         * If no active instance of [XignInDatabase] exists, creates a new instance of [XignInDatabase] and makes it
         * available through [instance].
         *
         * Creating a new instance of [XignInDatabase] either creates a new encrypted private SQLiteDatabase associated
         * with the [app]'s package or opens an existing one automatically migrating it to the latest version if
         * necessary.
         *
         * @param app The [Application] owning the database.
         * @param passphrase The passphrase used for database encryption.
         *
         * @throws Exception on opening an existing DB with a different passphrase than during creation.
         */
        @Synchronized
        @WorkerThread
        fun initialise(app: Application) {
            if (nullableInstance.value == null) {
                nullableInstance.value = Room
                    .databaseBuilder(
                        app,
                        AppDatabase::class.java,
                        NAME
                    )
                    .build()
            }
        }
        /**
         * Closes and invalidates the active instance of [XignInDatabase] if existent.
         *
         * After this function is called, any future access to [instance] will throw an error until the next call of
         * [initialise]
         *
         * @return true if there actually was an active instance to close; else false
         */
        @Synchronized
        @WorkerThread
        fun close() = nullableInstance.value?.let {
            nullableInstance.value = null
            it.close()
            true
        } ?: false
        /**
         * Deletes an existing private SQLiteDatabase associated with the [app]'s package.
         *
         * Calls: [close]
         *
         * @param app The [Application] owning the database.
         * @return true if the database was successfully deleted; else false.
         */
        @Synchronized
        @WorkerThread
        fun drop(app: Application) : Boolean {
            close()
            return app.deleteDatabase(NAME)
        }
        
    }
}
