package com.jersson.diaz.kriptochallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.core.text.isDigitsOnly
import com.jersson.diaz.domain.model.ApplicationData
import com.jersson.diaz.kriptochallenge.R

@Composable
fun AddApplicationScreen(
    onSaveClick: ((ApplicationData) -> Unit)?,
    onCancelClick: Runnable?
) {
    var name: String by remember { mutableStateOf("") }
    var category: String by remember { mutableStateOf("") }
    var frequency: Int by remember { mutableStateOf(0) }
    var cpuUsage: Int by remember { mutableStateOf(0) }
    var memoryUsage: Int by remember { mutableStateOf(0) }
    var lastUpdate: String by remember { mutableStateOf("") }
    var description: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(stringResource(id = R.string.insert_application), style = MaterialTheme.typography.h4)
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(id = R.string.application_name)) }
        )
        CategoryList(
            onSelect = {
                category = it ?: ""
            }
        )
        TextField(
            value = frequency.toString(),
            onValueChange = {
                if (it.isDigitsOnly() && it.isNotEmpty()) {
                    frequency = it.toInt()
                }
            },
            label = { Text(stringResource(id = R.string.frequency_user)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        TextField(
            value = cpuUsage.toString(),
            onValueChange = {
                if (it.isDigitsOnly() && it.isNotEmpty()) {
                    cpuUsage = it.toInt()
                }
            },
            label = { Text(stringResource(id = R.string.cpu_usage)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        TextField(
            value = memoryUsage.toString(),
            onValueChange = {
                if (it.isDigitsOnly() && it.isNotEmpty()) {
                    memoryUsage = it.toInt()
                }
            },
            label = { Text(stringResource(id = R.string.memory_consumption)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        TextField(
            value = lastUpdate,
            onValueChange = { lastUpdate = it },
            label = { Text(stringResource(id = R.string.last_update)) }
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(stringResource(id = R.string.description)) }
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { onCancelClick?.run() }
            ) {
                Text(stringResource(id = R.string.cancel))
            }
            Button(
                onClick = {
                    onSaveClick?.invoke(
                        ApplicationData(
                            name = name,
                            category = category,
                            frequency = frequency,
                            cpuUsage = cpuUsage,
                            memoryUsage = memoryUsage,
                            lastUpdate = lastUpdate
                        )
                    )
                }
            ) {
                Text(stringResource(id = R.string.save))
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryList(onSelect: ((String?) -> Unit)) {

    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Seleccione una categoria") }
    val options = listOf("Mensajería", "Juego", "Red Social", "Streaming")

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        BasicTextField(
            value = TextFieldValue(selectedOption),
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable { expanded = !expanded }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                        onSelect.invoke(option)
                    }
                )
            }
        }
    }
}