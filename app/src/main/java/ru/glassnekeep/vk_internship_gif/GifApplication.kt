package ru.glassnekeep.vk_internship_gif

import android.app.Application
import ru.glassnekeep.vk_internship_gif.di.AppComponent

class GifApplication: Application() {
    val appComponent: AppComponent by lazy {
        initAppComponent()
    }

    private fun initAppComponent(): AppComponent {

    }
}