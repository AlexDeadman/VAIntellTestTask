package ru.alexdeadman.vaintelltesttask.ui.livescores

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import ru.alexdeadman.vaintelltesttask.BuildConfig
import ru.alexdeadman.vaintelltesttask.data.soccers.SoccersRepository
import javax.inject.Inject

@HiltViewModel
class LivescoresViewModel @Inject constructor(
    private val repository: SoccersRepository
) : ViewModel() {

    private var fetchJob: Job? = null

    private val _livescoresStateFlow = MutableStateFlow<LivescoresState>(LivescoresState.Default)
    val livescoresStateFlow = _livescoresStateFlow.asStateFlow()

    init {
        fetchLivescores()
    }

    fun fetchLivescores() {
        _livescoresStateFlow.value = LivescoresState.Loading

        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(Dispatchers.IO) {
            repository.fetchLivescores(
                BuildConfig.USERNAME,
                BuildConfig.TOKEN,
                "today"
            ).catch {
                _livescoresStateFlow.value = LivescoresState.Error(it)
                if (BuildConfig.DEBUG) Log.e(TAG, it.toString())
            }.collect {
                _livescoresStateFlow.value =
                    if (it.data.isEmpty()) LivescoresState.Empty
                    else LivescoresState.Loaded(it)
            }
        }
    }

    companion object {
        private val TAG = LivescoresViewModel::class.simpleName
    }
}