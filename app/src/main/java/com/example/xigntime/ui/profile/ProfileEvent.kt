package com.example.xigntime.ui.profile

import com.example.xigntime.data.entities.User

//sends events from the ui to the viewmodel
sealed class ProfileEvent {

    //TODO: add possible events
    data class OnProfileClick(val user: User): ProfileEvent()
}
