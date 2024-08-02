package com.jersson.diaz.domain.model

data class ApplicationData(
    val code: Int = 0,
    var name: String = "",
    var category: String = "",
    var frequency: Int = 0,
    var cpuUsage: Int = 0,
    var memoryUsage: Int = 0,
    var lastUpdate: String = "",
    var description: String = ""
)