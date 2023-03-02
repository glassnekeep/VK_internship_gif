package ru.glassnekeep.vk_internship_gif.di

import dagger.Subcomponent
import ru.glassnekeep.vk_internship_gif.MainActivity
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.di.GifListScreenComponent
import ru.glassnekeep.vk_internship_gif.presentation.gif_screen.di.GifScreenComponent

@ActivityScope
@Subcomponent
interface MainActivityComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun createGifListScreenComponent(): GifListScreenComponent.Factory

    fun createGifScreenComponent(): GifScreenComponent.Factory


    fun inject(activity: MainActivity)

}