package ru.alexdeadman.vaintelltesttask.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alexdeadman.vaintelltesttask.data.soccers.retrofit.SoccersApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient = OkHttpClient()

    const val BASE_URL = "https://api.soccersapi.com/v2.2/"

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideSoccersApi(retrofit: Retrofit): SoccersApi = retrofit.create(SoccersApi::class.java)
}