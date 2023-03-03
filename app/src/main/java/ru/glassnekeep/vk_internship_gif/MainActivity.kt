package ru.glassnekeep.vk_internship_gif

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import ru.glassnekeep.vk_internship_gif.di.MainActivityComponent
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.GifListFragment

class MainActivity : AppCompatActivity() {

    val mainActivityComponent: MainActivityComponent by lazy {
        initMainActivityComponent()
    }

    private fun initMainActivityComponent(): MainActivityComponent {
        return (application as GifApplication).appComponent.mainActivityComponentFactory().create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container, GifListFragment())
                setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            }
        }
    }
}