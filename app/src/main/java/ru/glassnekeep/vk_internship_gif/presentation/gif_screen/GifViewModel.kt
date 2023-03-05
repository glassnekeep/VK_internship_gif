package ru.glassnekeep.vk_internship_gif.presentation.gif_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.glassnekeep.vk_internship_gif.data.Gif
import ru.glassnekeep.vk_internship_gif.data.GifRepository
import ru.glassnekeep.vk_internship_gif.utils.ErrorHolder
import javax.inject.Inject

class GifViewModel @Inject constructor(private val gifRepository: GifRepository): ViewModel() {

    private val _message = MutableLiveData<String>()

    val message: LiveData<String> get() = _message

    private val _gif = MutableLiveData<Gif>()

    val gif: LiveData<Gif> get() = _gif

    fun getGifWithId(id: String) {
        viewModelScope.launch {
            try {
                _gif.postValue(gifRepository.getGifWithId(id))
            } catch (exception: ErrorHolder) {
                _message.postValue(exception.message)
            }
        }
    }
}