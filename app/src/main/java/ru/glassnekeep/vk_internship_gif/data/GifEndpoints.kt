package ru.glassnekeep.vk_internship_gif.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GifEndpoints {
    @GET("search")
    suspend fun getSearchedGifList(@Query("api_key") apiKey: String, @Query("q") search: String, @Query("lang") language: String = "ru") : Response<GifListResponse>
    @GET("gif_id")
    suspend fun getGifWithId(@Path("gif_id") gifId: String, @Path("api_key") apiKey: String) : Response<GifResponse>
}