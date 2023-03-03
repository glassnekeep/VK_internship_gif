package ru.glassnekeep.vk_internship_gif.presentation.gif_screen.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.glassnekeep.vk_internship_gif.di.ViewModelKey
import ru.glassnekeep.vk_internship_gif.presentation.gif_screen.GifViewModel

@Module
interface GifScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(GifViewModel::class)
    fun bindGifViewModel(gifViewModel: GifViewModel): ViewModel

}