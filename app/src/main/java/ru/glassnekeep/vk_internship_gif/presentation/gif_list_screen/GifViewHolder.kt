package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import ru.glassnekeep.vk_internship_gif.R
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
            .apply(RequestOptions().override(1000))
            .thumbnail(Glide.with(binding.root.context).asGif().load(R.drawable.loading_placeholder).override(1000))
            .fitCenter()
            .addListener(object: RequestListener<GifDrawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<GifDrawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    binding.gif.setImageResource(R.drawable.loading_error)
                    return false
                }

                override fun onResourceReady(
                    resource: GifDrawable?,
                    model: Any?,
                    target: Target<GifDrawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

            })
            .into(binding.gif)
        binding.gif.setOnClickListener {
            itemClickListener(gif)
        }
    }
}