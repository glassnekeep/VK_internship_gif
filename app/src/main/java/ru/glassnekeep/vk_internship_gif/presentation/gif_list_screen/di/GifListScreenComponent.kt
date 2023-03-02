package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.di

import android.content.Context
import dagger.BindsInstance
import dagger.Subcomponent
import ru.glassnekeep.vk_internship_gif.data.Gif
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.GifListFragment

@Subcomponent(modules = [GifListModule::class])
interface GifListScreenComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance @GifListFragmentContext context: Context, @BindsInstance itemClickListener: (Gif) -> Unit) : GifListScreenComponent
    }

    fun inject(fragment: GifListFragment)
}