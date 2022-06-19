package com.fampay.contextualcards.ui.holder

import android.graphics.Color
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fampay.contextualcards.api.model.Cards
import com.fampay.contextualcards.databinding.LayoutCardHc5Binding
import com.fampay.contextualcards.ui.`interface`.ItemClickListener

class ImageCardViewHolder(private val binding: LayoutCardHc5Binding) : RecyclerView.ViewHolder(binding.root){
    fun bind(card: Cards, listener: ItemClickListener) {
        binding.apply {
//            card.backgroundImage.aspectRatio?.let {
//                root.layoutParams.apply {
//                    height = (width / it).toInt()
//                    root.layoutParams = this
//                }
//            }

            if (card.backgroundImage.imageUrl != null && card.backgroundImage.imageType == EXT)
                Glide.with(binding.root).load(card.backgroundImage.imageUrl).into(cardImage)

            root.setBackgroundColor(Color.parseColor(card.backgroundColor))
            root.setOnClickListener { card.url?.let { url -> listener.openLink(url) } }
        }
    }

    companion object ImageType {
        const val EXT = "ext"
    }
}