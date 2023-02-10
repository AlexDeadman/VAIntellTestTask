package ru.alexdeadman.vaintelltesttask.di.modules

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
//    @Provides
//    @Singleton
//    fun provideSoccersDatabase(
//        @ApplicationContext context: Context
//    ): SoccersDatabase =
//        Room.databaseBuilder(
//            context,
//            SoccersDatabase::class.java,
//            "soccers_database"
//        ).build()
}