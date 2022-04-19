package com.example.xigntime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.xigntime.data.AppDatabase
import com.example.xigntime.data.entities.Profile
import com.example.xigntime.data.entities.User
import com.example.xigntime.data.entities.WorkEntry
import com.example.xigntime.ui.NavGraphs
//import com.example.xigntime.ui.entry_detail.EntryDetailScreen
//import com.example.xigntime.ui.entry_list.EntryListScreen
//import com.example.xigntime.ui.entry_detail.EntryDetailScreen
//import com.example.xigntime.ui.entry_list.EntryListScreen
import com.example.xigntime.ui.theme.XignTimeTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
                DestinationsNavHost(navGraph = NavGraphs.root)
                        var userDao = AppDatabase.getInstance(this).userDao()
                    }
                }
            }
        }
        //var userDao = AppDatabase.getInstance(this).userDao()


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
