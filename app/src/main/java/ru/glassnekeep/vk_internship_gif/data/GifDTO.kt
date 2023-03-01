package ru.glassnekeep.vk_internship_gif.data

import com.google.gson.annotations.SerializedName

data class GifListResponse(
    @SerializedName("data") val gifList: List<GifDTO>,
    val pagination: Pagination,
    val meta: Meta
)

data class GifResponse(
    @SerializedName("data") val gif: GifDTO,
    val meta: Meta
)

data class GifDTO(
    val id: String,
    val title: String,
    val rating: String,
    val images: Images
)

data class Images(
    val original: Original,
    @SerializedName("preview_gif") val preview: PreviewGif
)

data class Original(
    val height: String,
    val width: String,
    val url: String
)

data class PreviewGif(
    val height: String,
    val width: String,
    val url: String
)

data class Pagination(
    @SerializedName("total_count") val totalCount: Int,
    val count: Int,
    val offset: Int
)

data class Meta(
    val status: Int,
    val msg: String,
    @SerializedName("response_id") val responseId: String
)
