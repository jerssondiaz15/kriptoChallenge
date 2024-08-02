package com.jersson.diaz.data.main.local.model.mapper

import com.jersson.diaz.data.main.local.model.DbApplicationData
import com.jersson.diaz.domain.model.ApplicationData

fun DbApplicationData.toDomain(): ApplicationData = with(this) {
    ApplicationData(
        code = code,
        name = name,
        category = category,
        frequency = frequency,
        cpuUsage = cpuUsage,
        memoryUsage = memoryUsage,
        lastUpdate = lastUpdate,
        description = description
    )
}

fun List<DbApplicationData>.toDomain(): List<ApplicationData> = this.map { it.toDomain() }

fun ApplicationData.toData(): DbApplicationData = with(this) {
    DbApplicationData(
        code = code,
        name = name,
        category = category,
        frequency = frequency,
        cpuUsage = cpuUsage,
        memoryUsage = memoryUsage,
        lastUpdate = lastUpdate,
        description = description
    )
}