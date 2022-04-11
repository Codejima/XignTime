package com.example.xigntime.util

//sends events from the viewmodel to the ui
// when something the viewmodel changes (i.e. navigate, ShowSnackbar)
sealed class UiEvent {

    object PopBackStack: UiEvent()
    data class Navigate(val route: String): UiEvent()
    data class ShowSnackbar(
        val message: String,
        val action: String? = null
    ): UiEvent()
}
