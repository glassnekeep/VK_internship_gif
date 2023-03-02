package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.glassnekeep.vk_internship_gif.data.Gif
import ru.glassnekeep.vk_internship_gif.databinding.GifItemBinding
import javax.inject.Inject

class GifAdapter @Inject constructor(
    var gifList: List<Gif>,
    private val itemClickListener: (Gif) -> Unit
): RecyclerView.Adapter<GifViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        return GifViewHolder(
            GifItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            itemClickListener
        )
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        holder.bind(gifList[position])
    }

    override fun getItemCount(): Int {
        return gifList.size
    }

}