package com.jersson.diaz.kriptochallenge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.diaz.kriptochallenge.R

@Composable
fun HomeScreen(
    onAddApplicationClick: Runnable?,
    onViewDashboardClick: Runnable?,
    onSettingsClick: Runnable?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onAddApplicationClick?.run() }) {
            Text(stringResource(id = R.string.add_application))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onViewDashboardClick?.run() }) {
            Text(stringResource(id = R.string.view_dashboard))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onSettingsClick?.run() }) {
            Text(stringResource(id = R.string.configuration))
        }
    }
}