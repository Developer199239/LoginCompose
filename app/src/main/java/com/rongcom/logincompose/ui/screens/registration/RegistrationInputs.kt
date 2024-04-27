package com.rongcom.logincompose.ui.screens.registration

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.rongcom.logincompose.R
import com.rongcom.logincompose.ui.common.customComposableViews.EmailTextField
import com.rongcom.logincompose.ui.common.customComposableViews.MobileNumberTextField
import com.rongcom.logincompose.ui.common.customComposableViews.NormalButton
import com.rongcom.logincompose.ui.common.customComposableViews.NormalButtonCentered
import com.rongcom.logincompose.ui.common.customComposableViews.PasswordTextField
import com.rongcom.logincompose.ui.screens.login.LoginScreen
import com.rongcom.logincompose.ui.screens.registration.state.RegistrationState
import com.rongcom.logincompose.ui.theme.AppTheme
import com.rongcom.logincompose.ui.theme.LoginComposeTheme

@Composable
fun RegistrationInputs(
    registrationState: RegistrationState,
    onEmailIdChange: (String) -> Unit,
    onMobileNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onSubmit: () -> Unit
){
    Column(modifier = Modifier.fillMaxWidth()){
        //Email Id
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = registrationState.emailId,
            onValueChange = onEmailIdChange,
            label = stringResource(id = R.string.registration_email_label),
            isError = registrationState.errorState.emailIdErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.emailIdErrorState.errorMessageStringResource),
            imeAction = ImeAction.Next

        )

        MobileNumberTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = registrationState.mobileNumber,
            onValueChange = onMobileNumberChange,
            label = stringResource(id = R.string.registration_mobile_label),
            isError = registrationState.errorState.mobileNumberErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.mobileNumberErrorState.errorMessageStringResource),
            imeAction = ImeAction.Next

        )

        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = registrationState.password,
            onValueChange = onPasswordChange,
            label = stringResource(id = R.string.login_password_label),
            isError = registrationState.errorState.passwordErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.passwordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Next

        )

        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = registrationState.confirmPassword,
            onValueChange = onConfirmPasswordChange,
            label = stringResource(id = R.string.registration_confirm_password_label),
            isError = registrationState.errorState.confirmPasswordErrorState.hasError,
            errorText = stringResource(id = registrationState.errorState.confirmPasswordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Done

        )

        NormalButtonCentered(
            modifier = Modifier.padding(top = AppTheme.dimens.paddingExtraLarge)
            ,
            text = stringResource(id = R.string.registration_button_text)
            ) {
            onSubmit.invoke()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegistrationInputs() {
    LoginComposeTheme {
        RegistrationInputs(
            registrationState = RegistrationState(),
            onEmailIdChange = {},
            onMobileNumberChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {}
        ) {

        }
    }
}