package com.fampay.contextualcards.ui.holder

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fampay.contextualcards.api.model.Cards
import com.fampay.contextualcards.databinding.LayoutCardHc6Binding
import com.fampay.contextualcards.ui.`interface`.ItemClickListener

class ArrowCardViewHolder(private val binding: LayoutCardHc6Binding) : RecyclerView.ViewHolder(binding.root){
    fun bind(card: Cards, listener: ItemClickListener) {
        binding.apply {
            cardTitle.text = card.title
            if (card.icon?.imageUrl != null && card.icon?.imageType == EXT)
                Glide.with(binding.root).load(card.icon?.imageUrl).into(cardImage)

            smallCardWithArrow.setOnClickListener { card.url?.let { url -> listener.openLink(url) } }
        }
    }

    companion object ImageType {
        const val EXT = "ext"
    }
}