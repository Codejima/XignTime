package com.example.xigntime.presentation.entry_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.xigntime.presentation.destinations.EntryDetailScreenDestination
import com.example.xigntime.presentation.util.Screen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

//generic placeholder for the time being
@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen( //EntryListScreen
    //navigator: DestinationsNavigator,
    navController: NavController,
    viewModel: EntryListViewModel = hiltViewModel()
) {
    //val entries = viewModel.entries.collectAsState(initial = emptyList())
    val scaffoldState = rememberScaffoldState()
    //val state = viewModel.state

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(EntryListEvent.OnStartTimeMeasurement)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            items(viewModel.entries) { entry ->
                EntryItem(
                    workEntry = entry,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            //navigator.navigate(EntryDetailScreenDestination())
                            //viewModel.onEvent(EntryListEvent.OnEntryClick(entry))
                        }
                        .padding(16.dp)
                )
            }

        }

/*        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.workEntries.size) { i ->
                val workEntry = state.workEntries[i]
                EntryItem(
                    workEntry = workEntry,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navigator.navigate(EntryDetailScreenDestination())
                        }
                        .padding(16.dp)
                )
                if (i < state.workEntries.size) {
                    Divider(
                        modifier = Modifier.padding(
                            horizontal = 16.dp
                        )
                    )
                }
            }

        }*/
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                //navigator.navigate(EntryDetailScreenDestination())
            }) {
                Text("Go to Entry Detail Screen")
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            Button(onClick = {
                viewModel.onEvent(EntryListEvent.OnStartTimeMeasurement)
            }) {
                Text("Start")
            }
        }
    }
}

@Composable
fun MyButton() = Button(onClick = { /*TODO*/ }) {

}

@Composable
fun MyTextField() = Text("")

