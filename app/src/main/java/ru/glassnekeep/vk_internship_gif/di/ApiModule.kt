package ru.glassnekeep.vk_internship_gif.di

import dagger.Module
import dagger.Provides

@Module
object ApiModule {

    @Provides
    @ApiKey
    fun provideApiKey() = "dhxsWH9a3pZcG0UHVtNIAarDa4m6cWyj"
}