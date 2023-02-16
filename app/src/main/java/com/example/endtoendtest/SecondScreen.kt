package com.example.endtoendtest

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen(
    onNavigateToNextScreen: () -> Unit
) {

    var showDetail by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            stringResource(id = R.string.second_screen_description),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = {
                showDetail = !showDetail
            }
        ){
            Text(stringResource(id = R.string.button_show_details))
        }
        if(showDetail){
            Text(
                stringResource(id = R.string.second_screen_detail_text)
            )
        }
        Button(onClick = {
            onNavigateToNextScreen()
        }) {
            Text(stringResource(id = R.string.navigate_to_third_screen))
        }
    }
}