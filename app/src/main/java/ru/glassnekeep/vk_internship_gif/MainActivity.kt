package ru.glassnekeep.vk_internship_gif

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.glassnekeep.vk_internship_gif.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    val activityComponent: MainActivityComponent by lazy {
        initMainActivityComponent()
    }

    private fun initMainActivityComponent() {
        return (application as )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}