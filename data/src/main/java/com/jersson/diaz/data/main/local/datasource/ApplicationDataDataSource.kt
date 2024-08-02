package com.jersson.diaz.data.main.local.datasource

import com.jersson.diaz.data.main.local.ApplicationDataDB
import com.jersson.diaz.data.main.local.model.DbApplicationData

class ApplicationDataDataSource(
    private val applicationDataDB: ApplicationDataDB
) {
    suspend fun insertApplicationData(dbApplicationData: DbApplicationData) = applicationDataDB.applicationDataDao().insertApplicationData(dbApplicationData)
    suspend fun getListDbApplicationData(): List<DbApplicationData> = applicationDataDB.applicationDataDao().getListDbApplicationData()
    suspend fun deleteDbApplicationData(dbApplicationData: DbApplicationData) = applicationDataDB.applicationDataDao().deleteDbApplicationData(dbApplicationData)
}