package ru.alexdeadman.vaintelltesttask.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.alexdeadman.vaintelltesttask.data.apiname.ApiNameRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ApiNameRepository
) : ViewModel() {
    // TODO
}