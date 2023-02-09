package ru.alexdeadman.vaintelltesttask.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.alexdeadman.vaintelltesttask.data.apiname.room.ApiNameDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideBinlistDatabase(
        @ApplicationContext context: Context
    ): ApiNameDatabase =
        Room.databaseBuilder(
            context,
            ApiNameDatabase::class.java,
            "apiname_database" // TODO
        ).build()
}