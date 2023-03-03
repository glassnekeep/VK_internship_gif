package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import ru.glassnekeep.vk_internship_gif.MainActivity
import ru.glassnekeep.vk_internship_gif.R
import ru.glassnekeep.vk_internship_gif.data.Gif
import ru.glassnekeep.vk_internship_gif.databinding.FragmentGifListBinding
import ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen.di.GifListScreenComponent
import ru.glassnekeep.vk_internship_gif.presentation.gif_screen.GifFragment
import javax.inject.Inject

class GifListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var gifAdapter: GifAdapter

    private var _binding: FragmentGifListBinding? = null

    private val binding get() = _binding!!

    private val gifListComponent: GifListScreenComponent by lazy {
        initGifListScreenComponent()
    }

    private val viewModel by viewModels<GifListViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        gifListComponent.inject(this)
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
        val recycler = binding.gifRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = DefaultItemAnimator()
            adapter = gifAdapter
        }
        setGifListObserver(viewModel)
        setSearchTextListener()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initGifListScreenComponent(): GifListScreenComponent {
        return (requireActivity() as MainActivity).mainActivityComponent.createGifListScreenComponent().create(requireContext()) { gif -> gifClickListener(gif) }
    }

    private fun gifClickListener(gif: Gif) {
        val fragment = GifFragment().apply { arguments = bundleOf(Pair("gif_id", gif.id)) }
        navigateToGifFragment(fragment)
    }

    private fun setSearchTextListener() {
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrBlank()) {
                    viewModel.getGifList(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //TODO Подумать, как лучше вызывать этот snackbar
                if (newText.isNullOrBlank()) Snackbar.make(binding.root, getString(R.string.enter_not_empty_search_phrase), Snackbar.LENGTH_SHORT).show()
                return true
            }
        })
    }

    private fun navigateToGifFragment(fragment: GifFragment) {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            setCustomAnimations(R.anim.slide_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out)
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }
    }

    private fun setGifListObserver(viewModel: GifListViewModel) {
        viewModel.gifList.observe(viewLifecycleOwner) { list ->
            val diffUtilCallback = GifListDiffUtilCallback(gifAdapter.gifList, list)
            val differences = DiffUtil.calculateDiff(diffUtilCallback)
            gifAdapter.gifList = list
            differences.dispatchUpdatesTo(gifAdapter)
        }
    }
}