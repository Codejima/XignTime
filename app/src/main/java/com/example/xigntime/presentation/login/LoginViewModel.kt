package com.example.xigntime.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.xigntime.data.repo.UserRepository
import com.example.xigntime.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    fun setUsernameText(username: String) {
        _usernameText.value = username
    }

    fun setPasswordText(password: String) {
        _passwordText.value = password
    }

    //var user = repository.getUserById(1)
    //var state by mutableStateOf(LoginState(user))

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