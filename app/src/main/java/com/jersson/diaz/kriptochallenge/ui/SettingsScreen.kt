package com.jersson.diaz.kriptochallenge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.diaz.domain.model.SettingsData
import com.jersson.diaz.kriptochallenge.R

@Composable
fun SettingsScreen(
    onSaveSettingsClick: ((SettingsData) -> Unit)?,
    onSettingsCancelClick: Runnable?
) {
    var maxCpuUsage by remember { mutableStateOf("") }
    var refreshFrequency by remember { mutableStateOf("") }
    var alertsEnabled by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(value = maxCpuUsage, onValueChange = { maxCpuUsage = it }, label = { Text(stringResource(id = R.string.CPU_threshold)) })
        TextField(value = refreshFrequency, onValueChange = { refreshFrequency = it }, label = { Text(stringResource(id = R.string.update_frequency)) })
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = alertsEnabled, onCheckedChange = { alertsEnabled = it })
            Text(stringResource(id = R.string.activate_alerts))
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { onSettingsCancelClick?.run() }) {
                Text(stringResource(id = R.string.cancel))
            }
            Button(onClick = {
                val settings = SettingsData(
                    maxCpuUsage = maxCpuUsage,
                    refreshFrequency = refreshFrequency,
                    alertsEnabled = alertsEnabled
                )
                onSaveSettingsClick?.invoke(settings)
            }) {
                Text(stringResource(id = R.string.save))
            }
        }
    }
}