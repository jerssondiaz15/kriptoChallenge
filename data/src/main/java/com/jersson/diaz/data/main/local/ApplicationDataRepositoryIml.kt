package com.jersson.diaz.data.main.local

import com.jersson.diaz.data.main.local.datasource.ApplicationDataDataSource
import com.jersson.diaz.data.main.local.model.mapper.toData
import com.jersson.diaz.data.main.local.model.mapper.toDomain
import com.jersson.diaz.domain.model.ApplicationData
import com.jersson.diaz.domain.repository.ApplicationDataRepository
import javax.inject.Inject

class ApplicationDataRepositoryIml @Inject constructor(
    private val applicationDataDataSource: ApplicationDataDataSource
): ApplicationDataRepository {
    override suspend fun insertApplicationData(applicationData: ApplicationData) {
        applicationDataDataSource.insertApplicationData(applicationData.toData())
    }

    override suspend fun getListApplicationData(): List<ApplicationData> {
        return applicationDataDataSource.getListDbApplicationData().toDomain()
    }

    override suspend fun deleteApplicationDat(applicationData: ApplicationData) {
        applicationDataDataSource.deleteDbApplicationData(applicationData.toData())
    }

}