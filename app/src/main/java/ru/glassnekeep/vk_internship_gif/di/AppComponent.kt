package ru.glassnekeep.vk_internship_gif.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [NetworkModule::class, ViewModelFactoryModule::class, ApiModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun mainActivityComponentFactory(): MainActivityComponent.Factory

    fun inject(application: Application)
}