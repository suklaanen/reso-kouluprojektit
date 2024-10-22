package com.example.groupfour.ui.screens.navi

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.groupfour.ui.theme.SolidBlue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.groupfour.R
import java.util.Locale

val customFont = FontFamily(
    Font(R.font.dancingscript)
)

@Composable
fun Navi(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val activity = context as? Activity

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(16.dp),
        contentAlignment = Alignment.Center

    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = {expanded = true},
                modifier = Modifier.padding(top = 16.dp)) {
                Icon(Icons.Filled.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .size(36.dp),
                    tint = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            Text(
               text = stringResource(R.string.titleApp),
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 28.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Center,
                fontFamily = customFont,
                fontSize = 36.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Box(modifier = Modifier.size(36.dp))
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {

            DropdownMenuItem(
                { Text(stringResource(R.string.naviAccount), color = SolidBlue) },
                onClick = { navController.navigate("navigateAccount")
                    expanded = false
                }
            )

            // Accountin alle kaikki oleellinen liittyen omaan tiliin.
            // Kirjautuneena tilin hallinta (change password, delete account, my dogs, me current meetings, add new dog)

            DropdownMenuItem(
                { Text(stringResource(R.string.naviMeetings), color = SolidBlue) },
                onClick = { navController.navigate("navigateMeetings")
                    expanded = false
                }
            )

            // Meetings kautta löytyy parks, add new park, add meeting, modify etc, join, remove my join ja muu oleellinen liittyen puistoihin ja tapaamisiin

            DropdownMenuItem(
                { Text(stringResource(R.string.naviFI), color = SolidBlue) },
                onClick = {
                    val locale = Locale("fi")
                    Locale.setDefault(locale)

                    val config = context.resources.configuration
                    config.setLocale(locale)

                    context.createConfigurationContext(config)

                    // Tämä deprecated tarvitaan
                    context.resources.updateConfiguration(config, context.resources.displayMetrics)

                    activity?.recreate()
                    expanded = false
                }
            )

            DropdownMenuItem(
                { Text(stringResource(R.string.naviEN), color = SolidBlue) },
                onClick = {
                    val locale = Locale.ENGLISH
                    Locale.setDefault(locale)

                    val config = context.resources.configuration
                    config.setLocale(locale)

                    context.createConfigurationContext(config)

                    // Tämä deprecated tarvitaan
                    context.resources.updateConfiguration(config, context.resources.displayMetrics)

                    activity?.recreate()
                    expanded = false
                }
            )

        }
    }
}