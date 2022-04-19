package com.example.xigntime.ui.profile


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xigntime.data.repo.ProfileRepository
import com.example.xigntime.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : ViewModel() {


    //var profile = repository.getProfileById(1)
    //var state by mutableStateOf(LoginState(profile))

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    //is triggered from the ui by interaction (event)
    /*fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnEntryClick -> {
                //TODO: add event
                sendUiEvent(UiEvent.Navigate(Routes.ENTRY_DETAIL + "?workEntryId${event.workEntry.workEntryId}"))
            }
            is LoginEvent.OnStartTimeMeasurement -> {
                //TODO: add event
                viewModelScope.launch {
                    //repository.insertEntry()
                }
            }
        }
    }*/

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}