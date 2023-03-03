package ru.glassnekeep.vk_internship_gif.presentation.gif_list_screen

import androidx.recyclerview.widget.DiffUtil
import ru.glassnekeep.vk_internship_gif.data.Gif

class GifListDiffUtilCallback(
    private val oldList: List<Gif>,
    private val newList: List<Gif>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition].id == oldList[oldItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList[newItemPosition] == oldList[oldItemPosition]
    }

}