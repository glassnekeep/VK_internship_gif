package ru.glassnekeep.vk_internship_gif.data

object GifToDTOMapper {
    fun dtoToGif(gifDTO: GifDTO): Gif {
        return Gif(
            gifDTO.id,
            gifDTO.title,
            gifDTO.images.original.url,
            gifDTO.rating
        )
    }
}