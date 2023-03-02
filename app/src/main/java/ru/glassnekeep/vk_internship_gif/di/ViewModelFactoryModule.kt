package ru.glassnekeep.vk_internship_gif.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.glassnekeep.vk_internship_gif.presentation.ViewModelFactory

@Module
interface ViewModelFactoryModule {
    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}