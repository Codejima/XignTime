package com.example.xigntime.presentation.entry_list

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.xigntime.data.AppDatabase
import com.example.xigntime.data.entities.WorkEntry
import com.example.xigntime.data.repo.EntryRepository
import com.example.xigntime.util.Routes
import com.example.xigntime.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EntryListViewModel @Inject constructor(
    private val repository: EntryRepository
) : ViewModel() {

    //private val _state = mutableStateOf(EntryListState())
    //val entries = repository.getEntry()
    //var state: State<EntryListState> = _state
    var entries by mutableStateOf<List<WorkEntry>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            AppDatabase.instance.workEntryDao().getEntry().asFlow().collect { //AppDatabase.instance.workEntryDao()
                entries = it
            }
        }
    }

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    //is triggered from the ui by interaction (event)
    fun onEvent(event: EntryListEvent) {
        when (event) {
            is EntryListEvent.OnEntryClick -> {
                //TODO: add event
                sendUiEvent(UiEvent.Navigate(Routes.ENTRY_DETAIL + "?workEntryId${event.workEntry.workEntryId}"))
            }
            is EntryListEvent.OnStartTimeMeasurement -> {
                //TODO: add event
                viewModelScope.launch {
                    //repository.insertEntry()
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}