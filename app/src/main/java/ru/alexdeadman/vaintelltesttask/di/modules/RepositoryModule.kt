package ru.alexdeadman.vaintelltesttask.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.alexdeadman.vaintelltesttask.data.apiname.ApiNameLocalDataSource
import ru.alexdeadman.vaintelltesttask.data.apiname.ApiNameRemoteDataSource
import ru.alexdeadman.vaintelltesttask.data.apiname.ApiNameRepository
import ru.alexdeadman.vaintelltesttask.data.apiname.retrofit.ApiNameApi
import ru.alexdeadman.vaintelltesttask.data.apiname.retrofit.RetrofitApiNameDataSource
import ru.alexdeadman.vaintelltesttask.data.apiname.room.ApiNameDatabase
import ru.alexdeadman.vaintelltesttask.data.apiname.room.RoomApiNameDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideApiNameRemoteDataSource(api: ApiNameApi): ApiNameRemoteDataSource =
        RetrofitApiNameDataSource(api)

    @Provides
    @Singleton
    fun provideLocalApiNameDataSource(database: ApiNameDatabase): ApiNameLocalDataSource =
        RoomApiNameDataSource(database.apiNameDao())

    @Provides
    @Singleton
    fun provideApiNameRepository(
        remote: ApiNameRemoteDataSource,
        local: ApiNameLocalDataSource
    ): ApiNameRepository = ApiNameRepository(remote, local)
}