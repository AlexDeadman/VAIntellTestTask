package ru.alexdeadman.vaintelltesttask.data.soccers

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores.Livescores

class SoccersRepository(
    private val soccersRemoteDataSource: SoccersRemoteDataSource,
    private val soccersLocalDataSource: SoccersLocalDataSource? = null // TODO temp null
) {
    fun fetchLivescores(
        username: String,
        token: String,
        time: String
    ): Flow<Livescores> = flow {
        emit(soccersRemoteDataSource.getLivescores(username, token, time))
    }
}