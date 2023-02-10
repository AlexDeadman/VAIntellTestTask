package ru.alexdeadman.vaintelltesttask.data.soccers

import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores.Livescores

interface SoccersRemoteDataSource {
    suspend fun getLivescores(
        username: String,
        token: String,
        time: String
    ): Livescores
}