package com.rongcom.logincompose.ui.screens.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import com.rongcom.logincompose.R
import com.rongcom.logincompose.ui.common.customComposableViews.EmailTextField
import com.rongcom.logincompose.ui.common.customComposableViews.NormalButton
import com.rongcom.logincompose.ui.common.customComposableViews.PasswordTextField
import com.rongcom.logincompose.ui.screens.login.state.LoginState
import com.rongcom.logincompose.ui.theme.AppTheme

@Composable
fun LoginInputs(
    loginState: LoginState,
    onEmailOrMobileChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSubmit: () -> Unit,
    onForgotPasswordClick: () -> Unit
){
    
    Column(modifier = Modifier.fillMaxWidth()) {
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.emailOrMobile,
            onValueChange = onEmailOrMobileChanged,
            label = stringResource(id = R.string.login_email_id_or_phone_label),
            isError = loginState.errorState.emailOrMobileErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.emailOrMobileErrorState.errorMessageStringResource)
        )
        
        //Password
        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppTheme.dimens.paddingLarge),
            value = loginState.password,
            onValueChange = onPasswordChanged,
            label = stringResource(id = R.string.login_password_label),
            isError = loginState.errorState.passwordErrorState.hasError,
            errorText = stringResource(id = loginState.errorState.passwordErrorState.errorMessageStringResource),
            imeAction = ImeAction.Done
        )
        
        //Forgot password
        Text(
           modifier = Modifier
               .padding(top = AppTheme.dimens.paddingSmall)
               .align(alignment = Alignment.End)
               .clickable {
                   onForgotPasswordClick.invoke()
               },
            text = stringResource(id = R.string.forgot_password),
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.bodyMedium
        )
        
        //Login Submit Button
        NormalButton(
            modifier = Modifier.padding(top = AppTheme.dimens.paddingLarge),
            onClick = onSubmit,
            text = stringResource(id = R.string.login_button_text))
    }
}
