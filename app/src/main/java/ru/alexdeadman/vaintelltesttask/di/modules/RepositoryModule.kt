package ru.alexdeadman.vaintelltesttask.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alexdeadman.vaintelltesttask.data.soccers.SoccersRemoteDataSource
import ru.alexdeadman.vaintelltesttask.data.soccers.SoccersRepository
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.RetrofitSoccersDataSource
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.SoccersApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideSoccersRemoteDataSource(api: SoccersApi): SoccersRemoteDataSource =
        RetrofitSoccersDataSource(api)

//    @Provides
//    @Singleton
//    fun provideSoccersLocalDataSource(database: SoccersDatabase): SoccersLocalDataSource =
//        RoomSoccersDataSource(database.soccersDao())

    @Provides
    @Singleton
    fun provideSoccersRepository(
        remote: SoccersRemoteDataSource,
//        local: SoccersLocalDataSource
    ): SoccersRepository = SoccersRepository(remote)
}