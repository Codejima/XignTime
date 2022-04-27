package com.example.xigntime.presentation.login

import com.example.xigntime.data.entities.User

//sends events from the ui to the viewmodel
sealed class LoginEvent {

    //TODO: add possible events
    data class OnLoginClick(val user: User): LoginEvent()
    data class OnRegisterClick(val user: User): LoginEvent()
}
