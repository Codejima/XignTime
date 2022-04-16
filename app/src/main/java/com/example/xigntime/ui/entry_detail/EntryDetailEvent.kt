package com.example.xigntime.ui.entry_detail

import java.time.Instant

//sends events from the ui to the viewmodel
sealed class EntryDetailEvent {

    data class OnEntryTitleChange(val entryTitle: String): EntryDetailEvent()
    data class OnTimeStartedChange(val entryTimeStarted: Long): EntryDetailEvent()
    data class OnTimeEndedChange(val entryTimeEnded: Long): EntryDetailEvent()
    data class OnEntryNotesChange(val entryNotes: String): EntryDetailEvent()
    object OnSaveEntryClick: EntryDetailEvent()
    object OnCancelEntryClick: EntryDetailEvent()
}
