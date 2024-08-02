package com.jersson.diaz.domain.usecase

import com.jersson.diaz.domain.model.ApplicationData
import com.jersson.diaz.domain.repository.ApplicationDataRepository
import javax.inject.Inject

class InsertApplicationDataUseCase @Inject constructor(
    private val applicationDataRepository: ApplicationDataRepository
) {
    suspend operator fun invoke(applicationData: ApplicationData){
        applicationDataRepository.insertApplicationData(applicationData)
    }
}