package com.rongcom.logincompose.ui.common.state

import androidx.annotation.StringRes
import com.rongcom.logincompose.R

/**
 * Error state holding values for error ui
 */
data class ErrorState(
    val hasError: Boolean = false,
    @StringRes val errorMessageStringResource: Int = R.string.empty_string
)