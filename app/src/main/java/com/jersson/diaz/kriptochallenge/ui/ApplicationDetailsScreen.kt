package com.jersson.diaz.kriptochallenge.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jersson.diaz.domain.model.ApplicationData
import com.jersson.diaz.kriptochallenge.R

@Composable
fun ApplicationDetailsScreen(
    application: ApplicationData,
    onDeleteClick: (() -> Unit)?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(stringResource(id = R.string.application_details), style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text("${stringResource(id = R.string.name)} ${application.name}")
        Text("${stringResource(id = R.string.category_point)} ${application.category}")
        Text("${stringResource(id = R.string.frequency_user_point)} ${application.frequency}")
        Text("${stringResource(id = R.string.cpu_usage_point)} ${application.cpuUsage}%")
        Text("${stringResource(id = R.string.memory_consumption_point)} ${application.memoryUsage}MB")
        Text("${stringResource(id = R.string.last_update_point)} ${application.lastUpdate}")
        Text("${stringResource(id = R.string.description_point)} ${application.description}")

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { onDeleteClick?.invoke() }) {
                Text(stringResource(id = R.string.delete))
            }
        }
    }
}