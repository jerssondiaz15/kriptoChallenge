package com.jersson.diaz.data.main.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jersson.diaz.data.main.local.dao.ApplicationDataDao
import com.jersson.diaz.data.main.local.model.DbApplicationData

@Database(
    entities = [
        DbApplicationData::class
    ],
    version = 1
)
abstract class ApplicationDataDB: RoomDatabase() {
    abstract fun applicationDataDao(): ApplicationDataDao
}