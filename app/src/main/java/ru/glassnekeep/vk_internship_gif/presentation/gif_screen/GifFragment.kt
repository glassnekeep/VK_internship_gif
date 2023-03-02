package ru.glassnekeep.vk_internship_gif.presentation.gif_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.glassnekeep.vk_internship_gif.R
import ru.glassnekeep.vk_internship_gif.databinding.FragmentGifBinding

class GifFragment : Fragment() {

    private var _binding: FragmentGifBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGifBinding.inflate(inflater, container, false)
        return binding.root
    }
}