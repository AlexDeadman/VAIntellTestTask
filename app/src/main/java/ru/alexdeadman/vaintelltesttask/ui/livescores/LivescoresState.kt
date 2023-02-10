package ru.alexdeadman.vaintelltesttask.ui.livescores

import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores.Livescores

sealed class LivescoresState {
    object Default : LivescoresState()
    object Loading: LivescoresState()
    class Loaded (val result: Livescores): LivescoresState()
    class Error (val throwable: Throwable) : LivescoresState()
}
