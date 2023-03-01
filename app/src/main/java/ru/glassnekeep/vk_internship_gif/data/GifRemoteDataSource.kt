package ru.glassnekeep.vk_internship_gif.data

import ru.glassnekeep.vk_internship_gif.di.ApiKey
import ru.glassnekeep.vk_internship_gif.di.ApplicationScope
import ru.glassnekeep.vk_internship_gif.utils.ErrorHolder
import javax.inject.Inject

@ApplicationScope
class GifRemoteDataSource @Inject constructor(
    private val gifEndpoints: GifEndpoints,
    @ApiKey
    private val apiKey: String
) {
    suspend fun getSearchedGifListFromRemote(searchString: String): List<GifDTO> {
        val response = gifEndpoints.getSearchedGifList(apiKey, searchString)
        with(response) {
            if (isSuccessful) {
                return body()?.gifList ?: emptyList()
            } else {
                throw ErrorHolder.BadRequest("Ошибка получения данных")
            }
        }
    }

    suspend fun getGifWithId(id: String): GifDTO {
        val response = gifEndpoints.getGifWithId(apiKey, id)
        with(response) {
            if (isSuccessful) {
                return body()?.gif ?: throw ErrorHolder.BadRequest("Ошибка получения данных")
            } else {
                throw ErrorHolder.BadRequest("Ошибка получения данных")
            }
        }
    }
}