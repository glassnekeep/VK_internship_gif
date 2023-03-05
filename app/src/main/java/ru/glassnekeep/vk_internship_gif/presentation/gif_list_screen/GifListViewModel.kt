package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.glassnekeep.vk_internship_gif.data.Gif
import ru.glassnekeep.vk_internship_gif.data.GifRepository
import ru.glassnekeep.vk_internship_gif.utils.ErrorHolder
import javax.inject.Inject

class GifListViewModel @Inject constructor(private val gifRepository: GifRepository): ViewModel() {

    private val _message = MutableLiveData<String>()

    val message: LiveData<String> get() = _message

    private val _gifList = MutableLiveData<List<Gif>>()

    val gifList: LiveData<List<Gif>> get() = _gifList

    private var getListJob: Job? = null

    init {
        getGifList("")
    }

    fun getGifList(searchString: String) {
        getListJob?.cancel()
        getListJob = viewModelScope.launch {
            try {
                val list = gifRepository.getSearchedGifList(searchString)
                _gifList.value = list
                if (list.isEmpty()) _message.value = "Введите корректный запрос"
                _gifList.postValue(gifRepository.getSearchedGifList(searchString))
            } catch (exception: ErrorHolder) {
                _message.postValue(exception.message)
            }
        }
    }
}