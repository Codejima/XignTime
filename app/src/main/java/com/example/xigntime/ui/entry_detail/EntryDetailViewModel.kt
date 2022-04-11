package com.example.xigntime.ui.entry_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xigntime.data.entities.Entry
import com.example.xigntime.data.repo.EntryRepository
import com.example.xigntime.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.Duration
import java.time.Instant
import javax.inject.Inject

@HiltViewModel
class EntryDetailViewModel @Inject constructor(
    private val repository: EntryRepository,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    //var entry by mutableStateListOf<Entry?>(null) old
    //var entry by mutableState<Entry?>(null) alternative
    var entry by mutableStateOf<Entry?>(null)
        private set

    var entryTitle by mutableStateOf("")
        private set

    var entryTimeStarted by mutableStateOf(Instant.now())
        private set

    var entryTimeEnded by mutableStateOf<Instant?>(null)
        private set

    var entryTimeElapsed by mutableStateOf<Duration?>(null)
        private set

    //TODO: add note via id?

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        val entryId = savedStateHandle.get<Int>("entryId")!!
        if (entryId != -1) {
            viewModelScope.launch {
                repository.getEntryById(entryId).let { entry ->
                    entryTitle = entry.entryTitle
                    entryTimeStarted = entry.entryTimeStarted ?: null
                    entryTimeEnded = entry.entryTimeEnded
                    entryTimeElapsed = entry.entryTimeElapsed
                    this@EntryDetailViewModel.entry = entry
                }
            }
        }
    }

    //is triggered from the ui by interaction (event)
    //
    fun onEvent(event: EntryDetailEvent) {
        when(event) {
            is EntryDetailEvent.OnEntryTitleChange -> {
                entryTitle = event.entryTitle
            }
            is EntryDetailEvent.OnTimeStartedChange -> {
                entryTimeStarted = event.entryTimeStarted
            }
            is EntryDetailEvent.OnTimeEndedChange -> {
                entryTimeEnded = event.entryTimeEnded
            }
            is EntryDetailEvent.OnEntryNotesChange -> {
                //TODO: add notes
            }
            is EntryDetailEvent.OnSaveEntryClick -> {
                viewModelScope.launch {
                    if (entryTitle.isBlank()) {
                        sendUiEvent(UiEvent.ShowSnackbar(
                            message = "Title may not be empty"
                        ))
                        return@launch
                    }
                    if (entryTimeStarted.isAfter(entryTimeEnded)) {
                        sendUiEvent(UiEvent.ShowSnackbar(
                            message = "Start Time must be before End Time"
                        ))
                        return@launch
                    }
                    val entryTimeEndedCopy = entryTimeEnded
                    if(entryTimeEndedCopy != null) {
                        if (entryTimeEndedCopy.isBefore(entryTimeStarted)) {
                            sendUiEvent(UiEvent.ShowSnackbar(
                                message = "End Time must be after Start Time"
                            ))
                            return@launch
                        }

                    }
                    val entryCopy = entry
                    if (entryCopy == null) {
                        sendUiEvent(UiEvent.ShowSnackbar(
                            message = "..."
                        ))
                        return@launch
                    }

                    //TODO: how to handle the params here?
                    repository.insertEntry(
                        Entry(
                            entryTitle = entryTitle,
                            entryTimeStarted = entryTimeStarted,
                            entryTimeEnded = entryTimeEnded,
                            entryTimeElapsed =  entryTimeElapsed,
                            entryId = entryCopy.entryId,
                            workDayId = entryCopy.workDayId,
                            notesId = entryCopy.notesId
                        )
                    )
                    sendUiEvent(UiEvent.PopBackStack)
                }
            }
            is EntryDetailEvent.OnCancelEntryClick -> {
                sendUiEvent(UiEvent.PopBackStack)
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}