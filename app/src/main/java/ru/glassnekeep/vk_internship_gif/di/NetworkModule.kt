package ru.glassnekeep.vk_internship_gif.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.glassnekeep.vk_internship_gif.data.GifEndpoints

@Module
object NetworkModule {

    private const val BASE_URL = "https://api.giphy.com/v1/gifs/"

    @ApplicationScope
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor { chain ->
            val request = chain.request().newBuilder().build()
            chain.proceed(request)
        }.build()
    }

    @ApplicationScope
    @Provides
    fun provideRetrofit(
        httpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @ApplicationScope
    @Provides
    fun provideEndPoints(retrofit: Retrofit): GifEndpoints = retrofit.create(GifEndpoints::class.java)
}