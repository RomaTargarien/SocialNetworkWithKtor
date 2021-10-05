package com.example.socialnetwork.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.socialnetwork.R

@Composable
fun StandardTextField(
    value: String = "",
    hint: String = "",
    isError: Boolean = false,
    maxLenght: Int = 40,
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChanged: (String) -> Unit
) {
    val isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    TextField(
        value = value,
        onValueChange = {
            if (it.length < maxLenght) {
                onValueChanged(it)
            } },
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.body1
            )
        },
        singleLine = true,
        isError = isError,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = if (isPasswordVisible  && isPasswordToggleDisplayed)
            PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isPasswordToggleDisplayed) {
                IconButton(onClick = {
                    isPasswordVisible = !isPasswordVisible
                }) {
                    Icon(
                        imageVector = if (isPasswordVisible)
                            Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = if (isPasswordVisible) {
                            stringResource(id = R.string.password_visible_content_description)
                        } else {
                            stringResource(id = R.string.password_hiden_content_description)
                        })
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}