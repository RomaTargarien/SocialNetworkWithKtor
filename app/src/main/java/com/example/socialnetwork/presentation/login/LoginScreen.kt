package com.example.socialnetwork.presentation.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.socialnetwork.R
import com.example.socialnetwork.presentation.components.StandardTextField
import com.example.socialnetwork.presentation.ui.theme.SpaceLarge
import com.example.socialnetwork.presentation.ui.theme.SpaceMedium
import com.example.socialnetwork.presentation.ui.theme.SpaceSmall

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(
        start = SpaceMedium,
        end = SpaceMedium,
        top = SpaceLarge,
        bottom = 50.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = SpaceMedium)
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                value = viewModel.userNameText.value,
                onValueChanged = {
                    viewModel.setUserNameText(it)
                },
                hint = stringResource(id = R.string.login_hint),
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            StandardTextField(
                value = viewModel.passwordText.value,
                onValueChanged = {
                    viewModel.setPasswordText(it)
                },
                hint = stringResource(id = R.string.passord_hint),
                keyboardType = KeyboardType.Password
            )
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.do_not_have_acc))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_up)
                withStyle(style = SpanStyle(
                    color = MaterialTheme.colors.primary
                )) {
                    append(signUpText)
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }

}