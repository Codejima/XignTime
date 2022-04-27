package com.example.xigntime.presentation.entry_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
//import com.example.xigntime.presentation.destinations.EntryListScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import java.time.Instant

//generic placeholder for the time being
@Destination
@Composable
fun EntryDetailScreen(
    navigator: DestinationsNavigator,
    viewModel: EntryDetailViewModel = hiltViewModel()
) {
    //val workEntry = workEntry
    val entry = viewModel.entry
    val scaffoldState = rememberScaffoldState()

    //TODO: add cancel button
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(EntryDetailEvent.OnSaveEntryClick)
                //navigator.navigate(EntryListScreenDestination())
            }) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Save"
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TextField(
                value = entry!!.entryTitle,
                onValueChange = {
                    viewModel.onEvent(EntryDetailEvent.OnEntryTitleChange(it))
                },
            placeholder = {
                Text(text = "Title")
            },
            modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = entry.entryTimeStarted.toString(),
                onValueChange = {
                    viewModel.onEvent(EntryDetailEvent.OnEntryTitleChange(it))
                },
                placeholder = {
                    Text(text = Instant.now().toString())
                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = entry.entryTimeEnded.toString(),
                onValueChange = {
                    viewModel.onEvent(EntryDetailEvent.OnEntryTitleChange(it))
                },
                placeholder = {
                    Text(text = Instant.now().toString())
                },
                modifier = Modifier.fillMaxWidth()
            )
            //TODO: add rest of entry textfields
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            //navigator.navigate(EntryListScreenDestination())
        }) {
            Text("Go back to Entry List Screen")
        }
    }
}
