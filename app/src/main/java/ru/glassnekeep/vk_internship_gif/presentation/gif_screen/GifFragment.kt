package ru.glassnekeep.vk_internship_gif.presentation.gif_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import ru.glassnekeep.vk_internship_gif.MainActivity
import ru.glassnekeep.vk_internship_gif.R
import ru.glassnekeep.vk_internship_gif.databinding.FragmentGifBinding
import ru.glassnekeep.vk_internship_gif.presentation.gif_screen.di.GifScreenComponent
import javax.inject.Inject

class GifFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var _binding: FragmentGifBinding? = null

    private val binding get() = _binding!!

    private val gifComponent: GifScreenComponent by lazy {
        initGifScreenComponent()
    }

    private val viewModel by viewModels<GifViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        gifComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            requireArguments().getString("gif_id").also {
                if (!it.isNullOrEmpty()) viewModel.getGifWithId(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGifBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setGifObserver(viewModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initGifScreenComponent(): GifScreenComponent {
        return (requireActivity() as MainActivity).mainActivityComponent.createGifScreenComponent().create()
    }

    private fun setGifObserver(viewModel: GifViewModel) {
        viewModel.gif.observe(viewLifecycleOwner) { gif ->
            binding.rating.text = "Rating: ${gif.rating}"
            binding.title.text = gif.title.ifBlank { getString(R.string.default_title) }
            Glide
                .with(binding.gif)
                .asGif()
                .load(gif.url)
                .override(1000)
                .thumbnail(Glide.with(binding.rating.context).asGif().load(R.drawable.loading_placeholder).override(600))
                .fitCenter()
                .into(binding.gif)
        }
    }
}