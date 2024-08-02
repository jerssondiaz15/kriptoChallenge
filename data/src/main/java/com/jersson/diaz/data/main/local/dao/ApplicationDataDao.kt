package com.jersson.diaz.data.main.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jersson.diaz.data.main.local.model.DbApplicationData

@Dao
interface ApplicationDataDao {
    @Insert
    suspend fun insertApplicationData(dbApplicationData: DbApplicationData)

    @Query("SELECT * FROM application_data")
    suspend fun getListDbApplicationData(): List<DbApplicationData>

    @Delete
    suspend fun deleteDbApplicationData(dbApplicationData: DbApplicationData)
}