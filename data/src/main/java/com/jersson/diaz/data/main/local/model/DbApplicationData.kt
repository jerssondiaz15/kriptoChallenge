package com.jersson.diaz.data.main.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "application_data"
)
data class DbApplicationData(
    @PrimaryKey(autoGenerate = true) val code: Int = 0,
    val name: String = "",
    val category: String = "",
    val frequency: Int,
    val cpuUsage: Int,
    val memoryUsage: Int,
    val lastUpdate: String = "",
    val description: String = ""
)