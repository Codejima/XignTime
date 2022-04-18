package com.example.xigntime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.xigntime.data.AppDatabase
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.entities.User
import com.example.xigntime.data.entities.WorkEntry
import com.example.xigntime.presentation.ScreenShown
import com.example.xigntime.ui.entry_detail.EntryDetailScreen
import com.example.xigntime.ui.entry_list.EntryItem
import com.example.xigntime.ui.entry_list.EntryListScreen
import com.example.xigntime.ui.entry_list.EntryListViewModel
//import com.example.xigntime.ui.entry_detail.EntryDetailScreen
//import com.example.xigntime.ui.entry_list.EntryListScreen
//import com.example.xigntime.ui.entry_detail.EntryDetailScreen
//import com.example.xigntime.ui.entry_list.EntryListScreen
import com.example.xigntime.ui.theme.XignTimeTheme
import com.example.xigntime.util.Routes
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.LocalTime
import java.time.ZoneId

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase.getInstance(this)
        lifecycleScope.launch {
            val user = User(1, "Helmut", "asdf1234", "asdf".toByteArray())
            db.userDao().insertUser(user)
            val profile = Profile(1, "Project thyssen", 1)
            db.profileDao().insertProfile(profile)
            val workEntry = WorkEntry(1, "Meeting", 1100L, 1200L, 100L, 1, 1)
            db.workEntryDao().insertEntry(workEntry)
        }
/*            setContent {
            XignTimeTheme {
                when (viewModel.currentScreen) {
                    ScreenShown.MainScreen -> MainScreen(viewModel)
                    ScreenShown.EntryScreen -> EntryScreen(viewModel, viewModel.activeEntry)
                    ScreenShown.OverviewScreen -> OverViewScreen(viewModel)
                }
            }
        }*/
        setContent {
            XignTimeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Routes.ENTRY_LIST
                ) {
                    composable(Routes.ENTRY_LIST) {
                        EntryListScreen(
                            onNavigate = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                    composable(
                        route = Routes.ENTRY_DETAIL + "?entryId={entryId}",
                        arguments =  listOf(
                            navArgument(name = "entryId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )
                    ) {
                        EntryDetailScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
        val userDao = AppDatabase.getInstance(this).userDao()
    }
}

/*
@Composable
fun MainScreen(model: EntryListViewModel) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize(1f)) {
        Column(verticalArrangement = Arrangement.SpaceAround) {
            Column(verticalArrangement = Arrangement.Bottom) {
                ButtonBoxView(model)
            }
            Column(verticalArrangement = Arrangement.Top) {
                EntryListView(model)
            }
        }
    }
}

@Composable
fun ButtonBoxView(model: EntryListViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(0.1f)
            .border(2.dp, Color.Red),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val currentEntry = model.activeEntry
        if (currentEntry != null) {
            Column(
                modifier = Modifier.padding(8.dp),
                Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = DateUtils.formatElapsedTime(currentEntry.entryElapsedTime.seconds))
            }
        }
        Column() {

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { model.onStartButtonPressed() },
                    modifier = Modifier.fillMaxWidth(0.2f)
                ) {
                    Text(text = "Start")
                }
                Button(
                    onClick = { model.onUpdateButtonPressed() },
                    modifier = Modifier.fillMaxWidth(0.2f)
                ) {
                    Text(text = "Update")
                }
                Button(
                    onClick = { model.onStopButtonPressed() },
                    modifier = Modifier.fillMaxWidth(0.2f)
                ) {
                    Text(text = "Stop")
                }
                Button(
                    onClick = { model.onNoteButtonPressed() },
                    modifier = Modifier.fillMaxWidth(0.2f)
                ) {
                    Text(text = "Note")
                }
                Button(
                    onClick = { model.currentScreen = ScreenShown.AddEntry },
                    modifier = Modifier.fillMaxWidth(0.3f)
                ) {
                    Text(text = "Add")
                }
                Button(
                    onClick = { model.currentScreen = ScreenShown.Entry },
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(text = "Entry")
                }
            }
        }
    }
}

@Composable
fun EntryListView(model: EntryListViewModel, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight(0.9f)

            .verticalScroll(scrollState)
            .border(2.dp, Color.Magenta)
    ) {
        Text(text = model.screenName)
        // Text(text = TotalTimeWorkDay) //TODO: add total time
        //TODO: add date picker

        //display every entry in entryList
        for (item in model.entryData) {
            EntryItem(item)
        }
        //TODO: display totalTimeDay
        TotalTimeView(model)

    }
}

@Composable
fun TotalTimeView(model: EntryListViewModel, modifier: Modifier = Modifier) {
    var helper: Duration? = null
    for (item in model.entryData) {
        helper = item.entryElapsedTime
        if (helper != null) {
            helper += item.entryElapsedTime
        }
    }
    if (helper != null) {
        Text(text = "Total Time: " + DateUtils.formatElapsedTime(helper.seconds))
    } else {
        Text(text = "Total Time: 00:00")
    }
}
*/
