package com.example.xigntime.presentation

//import com.example.xigntime.ui.entry_detail.EntryDetailScreen
//import com.example.xigntime.ui.entry_list.EntryListScreen
//import com.example.xigntime.ui.entry_detail.EntryDetailScreen
//import com.example.xigntime.ui.entry_list.EntryListScreen
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.xigntime.R
import com.example.xigntime.data.AppDatabase
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.entities.User
import com.example.xigntime.data.entities.WorkEntry
import com.example.xigntime.presentation.theme.XignTimeTheme
import com.example.xigntime.presentation.util.Navigation
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        val db = AppDatabase.getInstance(this)
        lifecycleScope.launch {
            val user = User(1, "Helmut", "asdf1234", "asdf".toByteArray())
            db.userDao().insertUser(user)
            val profile = Profile(1, "Project thyssen", 1)
            db.profileDao().insertProfile(profile)
            val workEntry = WorkEntry(1, "Meeting", 1100L, 1200L, 100L, 1, 1)
            db.workEntryDao().insertEntry(workEntry)
        }*/

        setContent {
            XignTimeTheme {
                if (!AppDatabase.isInitialised) {
                    LaunchedEffect(key1 = true) {
                        AppDatabase.initialise(application)
                        with(AppDatabase.instance) {
                            val user = User(1, "Helmuto", "asdf1234", "asdf".toByteArray())
                            userDao().insertUser(user)
                            val profile = Profile(1, "Project thyssen", 1)
                            profileDao().insertProfile(profile)
                            val workEntry = WorkEntry(1, "Meeting", 1000L, 1200L, 100L, 1, 1)
                            workEntryDao().insertEntry(workEntry)
                            val workEntry2 = WorkEntry(2, "Meeting 2", 1200L, 1400L, 100L, 1, 2)
                            workEntryDao().insertEntry(workEntry2)
                            val workEntry3 = WorkEntry(3, "Meeting 3", 1400L, 1600L, 100L, 1, 3)
                            workEntryDao().insertEntry(workEntry3)
                        }
                    }
                } else {
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
                //var userDao = AppDatabase.getInstance(this).userDao()
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Navigation()
                }
            }
        }
    }
}