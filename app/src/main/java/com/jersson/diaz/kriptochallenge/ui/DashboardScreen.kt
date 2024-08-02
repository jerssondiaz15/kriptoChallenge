package com.jersson.diaz.kriptochallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun DashboardScreen(
    applications: List<ApplicationData>,
    recommendations: List<String>,
    goDetail: ((ApplicationData) -> Unit)?,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(stringResource(id = R.string.dashboard), style = MaterialTheme.typography.h4)

        Text(stringResource(id = R.string.resource_consumption_chart))

        Text(stringResource(id = R.string.application_table))

        Spacer(modifier = Modifier.height(16.dp))

        applications.forEach {
            Text(modifier = Modifier.clickable { goDetail?.invoke(it) }, text = "- ${it.name}: ${it.category}, ${it.cpuUsage}% CPU, ${it.memoryUsage}MB Memoria")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(stringResource(id = R.string.recommendations))
        recommendations.forEach {
            Text("- $it")
        }
    }
}