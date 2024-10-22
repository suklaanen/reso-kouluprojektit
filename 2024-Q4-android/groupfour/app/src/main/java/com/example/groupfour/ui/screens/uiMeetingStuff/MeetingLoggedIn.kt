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
import com.example.groupfour.ui.components.Heading

@Composable
fun LoggedInView(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Heading(title = stringResource(R.string.titleParkdates))

    // Koirapuistot, koirapuiston lisääminen, tapaamisten lisääminen ja tapaamisten löytäminen
        AccountSection(navController, R.string.titleParkFind) {
            // puistot löydettävissä esim. sijainnin / kaupungin / nimen perusteella
            // puistot kartalle ? puistot listaan ? molemmat ?
        }
        AccountSection(navController, R.string.titleParkAddNew) {
            // lisää uusi puisto (puiston nimi, kaupunki ja sijainti (käyntiosoite))
            // käyttäjä ei voi poistaa lisäämiään tai muiden lisäämiä puistoja
            // pohdittavaa: poistetaanko käyttäjän lisäämä puisto jos käyttäjä poistuu palvelusta?
        }
        AccountSection(navController, R.string.titleMeetingCreate) {
            // tapaamisen lisääminen saatavilla olevaan koirapuistoon haluttuun ajankohtaan
            // sekä vapaamuotoinen tarkennus, esim. vain nartuille / isot koirat / vain alle 10kg jne.
        }
        AccountSection(navController, R.string.titleMeetingFind) {
            // löydä aktiiviset tapaamiset suodatuksen #kaikki tai #kaupunki / #alue perusteella,
            // mahdollisesti omaa sijaintia lähinnä olevat myös
        }

    // Kun klikataan auki tapaaminen, niin:
    // Näytetään kyseinen tapaaminen, ilmoitetut koirat, oman koiran ilmoittaminen ja ilmoittautumisen perutuus
        AccountSection(navController, R.string.titleMeetingCurrentMeeting) {
            // kyseisen tapaamisen aika ja paikka
        }
            AccountSection(navController, R.string.titleMeetingCurrentDogs) {
                // näytetään käyttäjälle tapaamiseen ilmoitetut koirat (koiran profiiliin pääsee)
            }
            AccountSection(navController, R.string.titleMeetingJoin) {
                // käyttäjä voi valita koiransa profiilin tai profiilit, jotka liittyvät tapaamiseen
            }
            AccountSection(navController, R.string.titleMeetingRemoveMe) {
                // käyttäjä voi poistaa liittyneitä koiriaan tapaamisesta, kun se on vielä aktiivinen
                // jos käyttäjä on viimeinen, joka poistuu tapaamisesta, tapaaminen poistuu palvelusta samalla
            }

        //AccountSection(navController, R.string.titleAccountVerify)
        //AccountVerify tulee kerran kunnes vahvistettu tili, meneekö se omaan osioon?
    }
}
