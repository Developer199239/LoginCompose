package com.rongcom.logincompose.ui.screens.login.state

sealed class LoginUiEvent{
    data class EmailOrMobileChanged(val inputValue: String) : LoginUiEvent()
    data class PasswordChanged(val inputValue: String) : LoginUiEvent()
    object Submit: LoginUiEvent()
}
