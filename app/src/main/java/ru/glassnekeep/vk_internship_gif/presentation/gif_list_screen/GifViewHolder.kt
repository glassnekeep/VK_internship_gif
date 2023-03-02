package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.glassnekeep.vk_internship_gif.data.Gif
import ru.glassnekeep.vk_internship_gif.databinding.GifItemBinding

class GifViewHolder(
    private val binding: GifItemBinding,
    private val itemClickListener: (Gif) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun bind(gif: Gif) {
        Glide
            .with(binding.gif)
            .asGif()
            .load(gif.url)
            .apply(RequestOptions().override(400, 300))
            .centerCrop()
            .into(binding.gif)
    }
}