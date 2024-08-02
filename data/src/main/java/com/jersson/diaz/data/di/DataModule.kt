package com.jersson.diaz.data.di

import android.content.Context
import androidx.room.Room
import com.jersson.diaz.data.main.local.ApplicationDataDB
import com.jersson.diaz.data.main.local.ApplicationDataRepositoryIml
import com.jersson.diaz.data.main.local.datasource.ApplicationDataDataSource
import com.jersson.diaz.domain.repository.ApplicationDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    private const val APPLICATION_DATA_DATABASE_NAME = "application_data_database"

    @Provides
    @Singleton
    fun provideApplicationDataDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ApplicationDataDB::class.java, APPLICATION_DATA_DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideApplicationDataDao(applicationDataDB: ApplicationDataDB) = applicationDataDB.applicationDataDao()

    @Provides
    fun provideApplicationDataRepository(applicationDataDataSource: ApplicationDataDataSource): ApplicationDataRepository {
        return ApplicationDataRepositoryIml(applicationDataDataSource)
    }
    @Provides
    fun provideApplicationDataDatabaseDataSource(applicationDataDB: ApplicationDataDB): ApplicationDataDataSource {
        return ApplicationDataDataSource(applicationDataDB)
    }
}