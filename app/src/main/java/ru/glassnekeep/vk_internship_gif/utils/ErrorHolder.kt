package ru.glassnekeep.vk_internship_gif.utils

sealed class ErrorHolder(override val message: String): Exception(message) {
    data class BadRequest(override val message: String) : ErrorHolder(message)
    data class InternalServerError(override val message: String) : ErrorHolder(message)
    data class NotFound(override val message: String) : ErrorHolder(message)
}