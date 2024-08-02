package com.jersson.diaz.domain.model

data class SettingsData(
    val maxCpuUsage: String,
    val refreshFrequency: String,
    val alertsEnabled: Boolean
)