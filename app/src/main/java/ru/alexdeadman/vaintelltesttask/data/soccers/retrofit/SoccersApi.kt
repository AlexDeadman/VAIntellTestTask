package ru.alexdeadman.vaintelltesttask.data.soccers.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.livescores.Livescores

interface SoccersApi {
    @GET("livescores/?")
    suspend fun getLivescores(
        @Query("user") username: String,
        @Query("token") token: String,
        @Query("t") time: String
    ): Livescores
}