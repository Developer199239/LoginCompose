package com.rongcom.logincompose.ui.screens.login.state

import com.rongcom.logincompose.R
import com.rongcom.logincompose.ui.common.state.ErrorState

val emailOrMobileEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_email_mobile
)

val passwordEmptyErrorState = ErrorState(
    hasError = true,
    errorMessageStringResource = R.string.login_error_msg_empty_password
)
