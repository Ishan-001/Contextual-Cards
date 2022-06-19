package com.fampay.contextualcards.ui.holder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fampay.contextualcards.api.model.Cards
import com.fampay.contextualcards.databinding.LayoutCardHc9Binding
import com.fampay.contextualcards.ui.`interface`.ItemClickListener

class DynamicWidthCardViewHolder(private val binding: LayoutCardHc9Binding) : RecyclerView.ViewHolder(binding.root){
    fun bind(card: Cards, mHeight : Int, listener: ItemClickListener) {
        binding.apply {
//            root.layoutParams.apply {
//                height = mHeight
//                width = mHeight
//                root.layoutParams = this
//                Log.d("layout params", root.layoutParams.width.toString() + root.layoutParams.height.toString())
//            }

            if (card.backgroundImage.imageUrl != null && card.backgroundImage.imageType == EXT)
                Glide.with(binding.root).load(card.backgroundImage.imageUrl).into(cardImage)

            cardImage.setOnClickListener { card.url?.let { url -> listener.openLink(url) } }
        }
    }

    companion object ImageType {
        const val EXT = "ext"
    }
}