package com.example.xigntime.presentation.entry_list

import com.example.xigntime.data.entities.WorkEntry

data class EntryListState(
    val workEntries: List<WorkEntry> = emptyList()
)
