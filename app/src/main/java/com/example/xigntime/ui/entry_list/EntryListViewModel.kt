package com.example.xigntime.ui.entry_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    val entries = repository.getEntry()
    val screenName by mutableStateOf("Main")

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    //is triggered from the ui by interaction (event)
    //
    fun onEvent(event: EntryListEvent) {
        when(event) {
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