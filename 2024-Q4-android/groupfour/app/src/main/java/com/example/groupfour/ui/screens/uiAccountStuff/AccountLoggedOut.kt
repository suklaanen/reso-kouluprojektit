package com.example.groupfour.ui.screens.uiAccountStuff

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groupfour.R
import com.example.groupfour.ui.components.AccountSection
import com.example.groupfour.ui.components.ButtonContinue
import com.example.groupfour.ui.components.CommonText
import com.example.groupfour.ui.components.Heading

@Composable
fun LoggedOutView(navController: NavController) {
    var loginUsername: String by remember { mutableStateOf("") }
    var registerUsername: String by remember { mutableStateOf("") }
    var registerEmail: String by remember { mutableStateOf("") }
    var forgottenEmail: String by remember { mutableStateOf("") }
    var loginPassword: String by remember { mutableStateOf("") }
    var registerPassword: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        rememberScrollState()
        Heading(title = stringResource(R.string.titleAccountPage))

        AccountSection(navController, R.string.titleAccountLogin) {
            CommonText(
                value = "Kirjaudu sisään omalla käyttäjätunnuksellasi ja salasanallasi.",
                onValueChange = {},
                editable = false
            )
            CommonText(
                value = loginUsername,
                onValueChange = { loginUsername = it },
                editable = true
            )
            CommonText(
                value = loginPassword,
                onValueChange = { loginPassword = it },
                editable = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon",
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )

            ButtonContinue(
                title = stringResource(R.string.buttonLogin),
                onClick =  {
                    navController.navigate("home")
                }
            )
        }

        AccountSection(navController, R.string.titleAccountCreate) {
            CommonText(
                value = "Rekisteröidy palvelun käyttäjäksi täyttämällä pyydetyt kohdat.",
                onValueChange = {},
                editable = false
            )
            CommonText(
                value = "Käyttäjätunnus:",
                onValueChange = {},
                editable = false
            )
            CommonText(
                value = registerUsername,
                onValueChange = { registerUsername = it },
                editable = true
            )
            CommonText(
                value = "Sähköposti:",
                onValueChange = {},
                editable = false
            )
            CommonText(
                value = registerEmail,
                onValueChange = { registerEmail = it },
                editable = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon"
                    )
                }
            )
            CommonText(
                value = "Salasana:",
                onValueChange = {},
                editable = false
            )
            CommonText(
                value = registerPassword,
                onValueChange = { registerPassword = it },
                editable = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon",
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )
            ButtonContinue(
                title = stringResource(R.string.buttonRegister),
                onClick =  {
                    navController.navigate("home")
                }
            )
        }

        AccountSection(navController, R.string.titleAccountForgotten) {
            CommonText(
                value = "Palauta salasana rekisteröimääsi sähköpostiin.",
                onValueChange = {},
                editable = false
            )
            CommonText(
                value = "Sähköposti:",
                onValueChange = {},
                editable = false
            )
            CommonText(
                value = forgottenEmail,
                onValueChange = { forgottenEmail = it },
                editable = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon"
                    )
                }
            )
            ButtonContinue(
                title = stringResource(R.string.buttonForgotten),
                onClick =  {
                    navController.navigate("home")
                }
            )
        }

    }
}