package ru.alexdeadman.vaintelltesttask.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alexdeadman.vaintelltesttask.data.apiname.retrofit.ApiNameApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient = OkHttpClient()

    @Provides
    @Singleton
    fun provideRetrofit(
        gson: Gson,
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl("https://url/") // TODO
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideApiNameApi(retrofit: Retrofit): ApiNameApi = retrofit.create(ApiNameApi::class.java)
}