package com.example.groupfour.ui.screens.uiMeetingStuff

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groupfour.R
import com.example.groupfour.ui.components.AccountSection
import com.example.groupfour.ui.components.CommonText
import com.example.groupfour.ui.components.Heading

@Composable
fun LoggedOutView(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Heading(title = stringResource(R.string.titleParkdates))
        AccountSection(navController, R.string.titleParkFind) {
            // puistot löydettävissä esim. sijainnin / kaupungin / nimen perusteella
            // puistot kartalle ? puistot listaan ? molemmat ?
            CommonText(
                value = "Koirapuistoja ei ole vielä saatavilla. " +
                        "\n Puistotreffit näkyvät vain kirjautuneille käyttäjille.",
                onValueChange = {},
                editable = false
            )
        }
    }
}
