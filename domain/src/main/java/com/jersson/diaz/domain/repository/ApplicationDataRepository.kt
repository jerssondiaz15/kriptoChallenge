package com.jersson.diaz.domain.repository

import com.jersson.diaz.domain.model.ApplicationData

interface ApplicationDataRepository {
    suspend fun insertApplicationData(applicationData: ApplicationData)
    suspend fun getListApplicationData(): List<ApplicationData>
    suspend fun deleteApplicationDat(applicationData: ApplicationData)
}