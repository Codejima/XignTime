package com.example.xigntime.presentation.registration

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.xigntime.R
import com.example.xigntime.presentation.components.StandardTextField
import com.example.xigntime.presentation.login.LoginViewModel
import com.example.xigntime.presentation.theme.SpaceLarge
import com.example.xigntime.presentation.theme.SpaceMedium
import com.example.xigntime.presentation.theme.SpaceSmall

@Composable
fun RegistrationScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
            start = SpaceLarge,
            end = SpaceLarge,
            top = SpaceLarge,
            bottom = 50.dp
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
                },
                hint = stringResource(id = R.string.login_hint)
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                text = viewModel.passwordText.value,
                onValueChange = {
                    viewModel.setPasswordText(it)
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password
            )
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.no_account_yet))
                append(" ")
                val registerText = stringResource(id = R.string.create_account)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.secondary
                    )
                ) {
                    append(registerText)
                }
            },

            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)

        )
        //Button(onClick = { navController.navigate(Screen.MainScreen.route) })
        Spacer(modifier = Modifier.height(SpaceSmall))
    }
}