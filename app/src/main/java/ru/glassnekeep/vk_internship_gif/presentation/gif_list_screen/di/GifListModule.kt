package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.glassnekeep.vk_internship_gif.data.Gif
import ru.glassnekeep.vk_internship_gif.di.ViewModelKey
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.GifAdapter
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.GifListViewModel
import ru.glassnekeep.vk_internship_gif.presentation.gif_screen.GifViewModel

@Module
interface GifListModule {

    @Binds
    @IntoMap
    @ViewModelKey(GifListViewModel::class)
    fun bindGifListViewModel(gifListViewModel: GifListViewModel): ViewModel

    companion object {
        @Provides
        fun provideGifAdapter(itemClickListener: (Gif) -> Unit): GifAdapter {
            return GifAdapter(listOf(), itemClickListener)
        }
    }
}