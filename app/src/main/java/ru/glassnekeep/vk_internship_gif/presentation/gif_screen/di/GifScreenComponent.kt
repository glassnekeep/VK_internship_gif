package ru.glassnekeep.vk_internship_gif.presentation.gif_screen.di

import dagger.Subcomponent
import ru.glassnekeep.vk_internship_gif.presentation.gif_screen.GifFragment

@Subcomponent
interface GifScreenComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): GifScreenComponent
    }

    fun inject(fragment: GifFragment)
}