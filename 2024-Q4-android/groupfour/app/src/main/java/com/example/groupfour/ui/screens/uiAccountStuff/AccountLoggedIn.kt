package com.example.groupfour.ui.screens.uiAccountStuff

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.groupfour.R
import com.example.groupfour.ui.components.AccountSection
import com.example.groupfour.ui.components.Heading

@Composable
fun LoggedInView(navController: NavController) {

    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Heading(title = stringResource(R.string.titleAccountPage))
        AccountSection(navController, R.string.titleAccountMyDogs) {}
        // oman sivun kautta näkymä omista koirista
        AccountSection(navController, R.string.titleAccountMyMeetings) {}
        // käyttäjä löytää oman sivunsa kautta aktiiviset osallistumisensa
        AccountSection(navController, R.string.titleDogProfileCreate) {}
        // koiran profiiliin halutaan antaa koiran nimi, rotu, sukupuoli ja profiilikuva (puhelimen kuvista)
        AccountSection(navController, R.string.titleDogProfileModify) {}
        // käyttäjä voi muokata koiransa tietoja (mm. typot) ja vaihtaa profiilikuvaa
        AccountSection(navController, R.string.titleDogProfileDelete) {}
        // käyttäjä voi poistaa koiran palvelusta
        AccountSection(navController, R.string.titleAccountChangePassword) {}
        AccountSection(navController, R.string.titleAccountDelete) {}
        // jos tili poistetaan, poistetaan myös käyttäjän koirien profiilit sekä aktiiviset osallistumiset

        // käyttäjällä itsellään ei ole profiilikuvaa
        // koiran profiilista vaihtoehtoisestivoi nähdä käyttäjän (omistajan) nimimerkin (jos haluaa sen tiedon antaa)

        //AccountSection(navController, R.string.titleAccountVerify)
        //AccountVerify tulee kerran kunnes vahvistettu tili, meneekö se omaan osioon?
    }
}
