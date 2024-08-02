package com.jersson.diaz.kriptochallenge

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jersson.diaz.domain.model.ApplicationData
import com.jersson.diaz.domain.usecase.DeleteApplicationDataUseData
import com.jersson.diaz.domain.usecase.GetListApplicationDataUseData
import com.jersson.diaz.domain.usecase.InsertApplicationDataUseCase
import com.jersson.diaz.kriptochallenge.model.MainState
import com.jersson.diaz.kriptochallenge.navigation.UIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val insertApplicationDataUseCase: InsertApplicationDataUseCase,
    private val getListApplicationDataUseData: GetListApplicationDataUseData,
    private val deleteApplicationDataUseData: DeleteApplicationDataUseData
): ViewModel() {


    private var _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    private var _events = MutableSharedFlow<UIEvents>()
    val events: SharedFlow<UIEvents>
        get() = _events

    fun goAddApplicationClick() {
        viewModelScope.launch {
            _events.emit(UIEvents.GoAddApplicationScreen)
        }
    }

    fun goViewDashboardClick() {
        viewModelScope.launch {
            val response = getListApplicationDataUseData.invoke()
            _state.value = state.value.copy(
                listApplications = response,
            )
            getRecommendations()
            _events.emit(UIEvents.GoDashboardScreen)
        }
    }

    fun goSettingsClick() {
        viewModelScope.launch {
            _events.emit(UIEvents.GoSettingsScreen)
        }
    }

    fun goApplicationDetail(applicationData: ApplicationData) {
        viewModelScope.launch {
            _state.value = state.value.copy(
                application = applicationData
            )
            _events.emit(UIEvents.GoApplicationDetailsScreen)
        }
    }

    fun insertApplicationData(applicationData: ApplicationData) {
        viewModelScope.launch {
            insertApplicationDataUseCase.invoke(applicationData)
            val response = getListApplicationDataUseData.invoke()
            _state.value = state.value.copy(
                listApplications = response
            )
            getRecommendations()
            _events.emit(UIEvents.GoDashboardScreen)
        }
    }

    fun deleteApplicationData() {
        viewModelScope.launch {
            deleteApplicationDataUseData.invoke(state.value.application)
            val response = getListApplicationDataUseData.invoke()
            _state.value = state.value.copy(
                listApplications = response
            )
            getRecommendations()
            _events.emit(UIEvents.GoDashboardScreen)
        }
    }

    private fun getRecommendations() {
        val countCategory = mutableMapOf<String, Int>()
        for (application in state.value.listApplications) {
            countCategory[application.category] = (countCategory[application.category] ?: 0) + 1
        }
        val listRecommendations = mutableListOf<String>()
        for ((category, counting) in countCategory) {
            if (counting > 2) {
                val recommendations = when (category) {
                    "Juego" -> "Podrías pasar menos tiempo en los juegos."
                    "Mensajería" -> "Podrias intentar usar solo un app de mensajeria."
                    "Red Social" -> "Tener muchas apps de redes sociales puede ser muy distractivo."
                    "Streaming" -> "Tener muchas apps de streaming puede ser muy distractivo."
                    else -> "Aun no se puede tener un diagnostico adecuado, intenta ingresando mas aplicaciones que usas."
                }
                listRecommendations.add(recommendations)
            }
        }
        _state.value = state.value.copy(
            recommendations = listRecommendations
        )
    }
}