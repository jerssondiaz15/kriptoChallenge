package com.jersson.diaz.kriptochallenge.model

import com.jersson.diaz.domain.model.ApplicationData
import com.jersson.diaz.domain.model.SettingsData


data class MainState(
    val mainFunctions: MainFunctions = MainFunctions(),
    val listApplications: List<ApplicationData> = listOf(),
    val recommendations: List<String> = listOf(),
    val application: ApplicationData = ApplicationData(),
)

data class MainFunctions(
    val onSaveClick: ((ApplicationData) -> Unit)? = null,
    val onCancelClick: Runnable? = null,
    val onRefreshClick: Runnable? = null,
    val onSaveSettingsClick: ((SettingsData) -> Unit)? = null,
    val onSettingsCancelClick: Runnable? = null,
    val onEditClick: (() -> Unit)? = null,
    val onDeleteClick: (() -> Unit)? = null
)