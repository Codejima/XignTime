package com.example.xigntime.ui.entry_list

import com.example.xigntime.data.entities.Entry

//sends events from the ui to the viewmodel
sealed class EntryListEvent {

    //TODO: add possible events
    data class OnEntryClick(val entry: Entry): EntryListEvent()
    object OnStartTimeMeasurement: EntryListEvent()
}
