package com.rongcom.logincompose.ui.screens.registration

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.rongcom.logincompose.ui.common.state.ErrorState
import com.rongcom.logincompose.ui.screens.login.state.passwordEmptyErrorState
import com.rongcom.logincompose.ui.screens.registration.state.RegistrationErrorState
import com.rongcom.logincompose.ui.screens.registration.state.RegistrationState
import com.rongcom.logincompose.ui.screens.registration.state.RegistrationUiEvent
import com.rongcom.logincompose.ui.screens.registration.state.confirmPasswordEmptyErrorState
import com.rongcom.logincompose.ui.screens.registration.state.emailEmptyErrorState
import com.rongcom.logincompose.ui.screens.registration.state.mobileNumberEmptyErrorState
import com.rongcom.logincompose.ui.screens.registration.state.passwordMismatchErrorState

class RegistrationViewModel : ViewModel() {
    var registrationState = mutableStateOf(RegistrationState())
        private set

    fun onUiEvent(registrationUiEvent: RegistrationUiEvent) {
        when (registrationUiEvent) {
            is RegistrationUiEvent.EmailChanged -> {
                registrationState.value = registrationState.value.copy(
                    emailId = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        emailIdErrorState = if (registrationUiEvent.inputValue.trim().isEmpty()) {
                            emailEmptyErrorState
                        } else {
                            ErrorState()
                        }
                    ),
                )
            }
            is RegistrationUiEvent.MobileNumberChanged -> {
                registrationState.value = registrationState.value.copy(
                    mobileNumber = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        mobileNumberErrorState = if (registrationUiEvent.inputValue.trim().isEmpty()) {
                            mobileNumberEmptyErrorState
                        } else {
                            ErrorState()
                        }
                    ),
                )
            }
            is RegistrationUiEvent.PasswordChanged -> {
                registrationState.value = registrationState.value.copy(
                    password = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        passwordErrorState = if (registrationUiEvent.inputValue.trim().isEmpty()) {
                            passwordEmptyErrorState
                        } else {
                            ErrorState()
                        }
                    ),
                )
            }
            is RegistrationUiEvent.ConfirmPasswordChanged -> {
                registrationState.value = registrationState.value.copy(
                    confirmPassword = registrationUiEvent.inputValue,
                    errorState = registrationState.value.errorState.copy(
                        confirmPasswordErrorState = if (registrationUiEvent.inputValue.trim().isEmpty()) {
                            confirmPasswordEmptyErrorState
                        } else {
                            ErrorState()
                        }
                    ),
                )
            }
            RegistrationUiEvent.Submit -> {
                val inputsValidated = validateInputs()
                if(inputsValidated) {
                    registrationState.value = registrationState.value.copy(
                        isRegistrationSuccessful = true
                    )
                }
            }
        }
    }

    private fun validateInputs(): Boolean {
        val emailString = registrationState.value.emailId.trim()
        val mobileNumberString = registrationState.value.mobileNumber.trim()
        val passwordString = registrationState.value.password.trim()
        val confirmPasswordString = registrationState.value.confirmPassword.trim()

        return when {

            // Email empty
            emailString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        emailIdErrorState = emailEmptyErrorState
                    )
                )
                false
            }

            //Mobile Number Empty
            mobileNumberString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        mobileNumberErrorState = mobileNumberEmptyErrorState
                    )
                )
                false
            }

            //Password Empty
            passwordString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        passwordErrorState = passwordEmptyErrorState
                    )
                )
                false
            }

            //Confirm Password Empty
            confirmPasswordString.isEmpty() -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        confirmPasswordErrorState = confirmPasswordEmptyErrorState
                    )
                )
                false
            }

            // Password and Confirm Password are different
            passwordString != confirmPasswordString -> {
                registrationState.value = registrationState.value.copy(
                    errorState = RegistrationErrorState(
                        confirmPasswordErrorState = passwordMismatchErrorState
                    )
                )
                false
            }

            // No errors
            else -> {
                // Set default error state
                registrationState.value =
                    registrationState.value.copy(errorState = RegistrationErrorState())
                true
            }
        }
    }
}