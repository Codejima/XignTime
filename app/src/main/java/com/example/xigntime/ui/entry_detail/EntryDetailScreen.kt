package com.example.xigntime.ui.entry_detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.xigntime.util.UiEvent
import kotlinx.coroutines.flow.collect
import java.time.Instant

//generic placeholder for the time being

@Composable
fun EntryDetailScreen(
    onPopBackStack: () -> Unit,
    viewModel: EntryDetailViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.PopBackStack -> onPopBackStack()
                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action
                    )
                }
                else -> Unit
            }
        }
    }
    //TODO: add cancel button
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(EntryDetailEvent.OnSaveEntryClick)
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
                value = viewModel.entryTitle,
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
                value = viewModel.entryTimeStarted.toString(),
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
                value = viewModel.entryTimeEnded.toString(),
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
}