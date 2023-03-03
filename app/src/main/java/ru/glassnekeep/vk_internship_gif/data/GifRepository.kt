package ru.glassnekeep.vk_internship_gif.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.glassnekeep.vk_internship_gif.di.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class GifRepository @Inject constructor(
    private val gifRemoteDataSource: GifRemoteDataSource
) {
    suspend fun getSearchedGifList(searchString: String): List<Gif> {
        return withContext(Dispatchers.IO) {
            gifRemoteDataSource.getSearchedGifListFromRemote(searchString).map {
                GifToDTOMapper.dtoToGif(it)
            }
        }
    }

    suspend fun getGifWithId(id: String): Gif {
        return withContext(Dispatchers.IO) {
            GifToDTOMapper.dtoToGif(gifRemoteDataSource.getGifWithId(id))
        }
    }
}