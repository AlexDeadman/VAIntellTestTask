package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit

import ru.alexdeadman.vaintelltesttask.data.soccers.SoccersRemoteDataSource
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores.Livescores

class RetrofitSoccersDataSource(
    private val soccersApi: SoccersApi
) : SoccersRemoteDataSource {
    override suspend fun getLivescores(
        username: String,
        token: String,
        time: String
    ): Livescores = soccersApi.getLivescores(username, token, time)
}