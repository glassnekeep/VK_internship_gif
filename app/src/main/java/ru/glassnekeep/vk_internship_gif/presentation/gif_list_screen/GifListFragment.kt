package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ru.glassnekeep.vk_internship_gif.MainActivity
import ru.glassnekeep.vk_internship_gif.R
import ru.glassnekeep.vk_internship_gif.databinding.FragmentGifListBinding
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.di.GifListComponent
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.di.GifListScreenComponent
import javax.inject.Inject

class GifListFragment : Fragment() {

    private var _binding: FragmentGifListBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var gifAdapter: GifAdapter

    private fun initComponent(): GifListScreenComponent {
        return (requireActivity() as MainActivity).activityCom
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGifListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gifRecycler
    }
}